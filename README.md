# masker
spring boot 프로젝트에서 간편하게 사용할 수 있는 라이브러리


### 사용방법

```
# application.yaml
makser:
  active: true
```

```
class SampleUserResponse {
  @Masker(MaskingType.NAME)
  private val name;
  @Masker(MaskingType.EMAIL)
  private val email;

  // 생성자, getter 추가
}
```

적용 완료
