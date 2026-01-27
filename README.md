# Masker

Spring Boot 프로젝트에서 개인정보를 간편하게 마스킹 처리할 수 있는 라이브러리입니다.

## 호환 버전

| 항목 | 버전 |
|------|------|
| Java | 17+ |
| Spring Boot | 3.x |
| Jackson | 2.x |

## 설치

### Gradle

```groovy
dependencies {
    implementation 'kr.masker:core:0.0.1-SNAPSHOT'
}
```

### Maven

```xml
<dependency>
    <groupId>kr.masker</groupId>
    <artifactId>core</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## 사용 방법

### 1. 설정 활성화

`application.yml` 또는 `application.properties`에서 masker를 활성화합니다.

```yaml
# application.yml
masker:
  active: true
```

```properties
# application.properties
masker.active=true
```

### 2. 어노테이션 적용

마스킹이 필요한 필드에 `@Masker` 어노테이션을 추가합니다.

```java
import kr.masker.core.integration.annotation.Masker;
import kr.masker.core.util.MaskerType;

public class UserResponse {

    @Masker(maskerType = MaskerType.NAME)
    private String name;

    @Masker(maskerType = MaskerType.EMAIL)
    private String email;

    @Masker(maskerType = MaskerType.PHONE)
    private String phone;

    @Masker(maskerType = MaskerType.PASSWORD)
    private String password;

    // 생성자, getter 생략
}
```

### 3. 대체 문자 설정 (선택)

클래스 레벨에서 `@MaskerReplacement` 어노테이션을 사용하여 대체 문자를 지정할 수 있습니다.

```java
import kr.masker.core.integration.annotation.Masker;
import kr.masker.core.integration.annotation.MaskerReplacement;
import kr.masker.core.util.MaskerType;
import kr.masker.core.util.Replacement;

@MaskerReplacement(Replacement.SHARP)  // 클래스 내 모든 마스킹에 # 사용
public class UserResponse {

    @Masker(maskerType = MaskerType.NAME)
    private String name;  // 홍길동 → 홍#동

    @Masker(maskerType = MaskerType.EMAIL)
    private String email;  // test@gmail.com → tes#@g########

    // 생성자, getter 생략
}
```

## 마스킹 타입

| 타입 | 설명 | 입력 예시 | 출력 예시 |
|------|------|-----------|-----------|
| `ALL` | 전체 마스킹 | `test123` | `********` |
| `NAME` | 이름 마스킹 (첫/끝 글자 제외) | `홍길동` | `홍*동` |
| `EMAIL` | 이메일 마스킹 | `test@gmail.com` | `tes*@g********` |
| `PHONE` | 전화번호 마스킹 (가운데 자리) | `01011112222` | `010****2222` |
| `PASSWORD` | 비밀번호 전체 마스킹 | `password123` | `***********` |

### 이름 마스킹 규칙

- 2자리 이하: 마지막 글자 마스킹 (`홍현` → `홍*`)
- 3자리 이상: 첫/끝 글자 제외하고 마스킹 (`홍길동` → `홍*동`, `james` → `j***s`)

## 옵션

### 대체 문자 (Replacement)

클래스 레벨에서 `@MaskerReplacement` 어노테이션을 사용하여 설정합니다.

```java
@MaskerReplacement(Replacement.ASTERISK)  // 기본값: *
public class UserResponse { ... }

@MaskerReplacement(Replacement.SHARP)     // #
public class AnotherResponse { ... }
```

| 옵션 | 대체 문자 |
|------|-----------|
| `ASTERISK` | `*` (기본값) |
| `SHARP` | `#` |

### 대체 전략 (ReplaceStrategy)

필드 레벨에서 `@Masker` 어노테이션의 `strategy` 속성으로 설정합니다.

```java
@Masker(maskerType = MaskerType.ALL, strategy = ReplaceStrategy.DEFAULT)  // 자릿수 유지
@Masker(maskerType = MaskerType.ALL, strategy = ReplaceStrategy.ONE)      // 1자리로 통일
```

| 옵션 | 설명 | 입력 예시 | 출력 예시 |
|------|------|-----------|-----------|
| `DEFAULT` | 자릿수에 맞게 마스킹 (기본값) | `test@gmail.com` | `***************` |
| `ONE` | 1자리로 통일 | `test@gmail.com` | `*` |

## 전체 예시

```java
import kr.masker.core.integration.annotation.Masker;
import kr.masker.core.integration.annotation.MaskerReplacement;
import kr.masker.core.util.MaskerType;
import kr.masker.core.util.Replacement;
import kr.masker.core.util.ReplaceStrategy;

@MaskerReplacement(Replacement.ASTERISK)  // 클래스 내 모든 마스킹에 * 사용 (기본값)
public class UserResponse {

    @Masker(maskerType = MaskerType.NAME)
    private String name;  // 홍길동 → 홍*동

    @Masker(maskerType = MaskerType.EMAIL)
    private String email;  // test@gmail.com → tes*@g********

    @Masker(maskerType = MaskerType.PHONE)
    private String phone;  // 01011112222 → 010****2222

    @Masker(maskerType = MaskerType.PASSWORD, strategy = ReplaceStrategy.ONE)
    private String password;  // password123 → *

    // 생성자, getter 생략
}
```

### # 대체 문자로 사용하기

```java
@MaskerReplacement(Replacement.SHARP)  // 클래스 내 모든 마스킹에 # 사용
public class AdminResponse {

    @Masker(maskerType = MaskerType.NAME)
    private String name;  // 홍길동 → 홍#동

    @Masker(maskerType = MaskerType.EMAIL)
    private String email;  // test@gmail.com → tes#@g########

    // 생성자, getter 생략
}
```

## 동작 원리

이 라이브러리는 Spring Boot의 `Jackson2ObjectMapperBuilderCustomizer`를 통해 Jackson ObjectMapper에 커스텀 `AnnotationIntrospector`를 등록합니다. `@Masker` 어노테이션이 붙은 필드는 JSON 직렬화 시 자동으로 마스킹 처리됩니다.

## 라이선스

MIT License
