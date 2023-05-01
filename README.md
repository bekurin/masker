# obsure

spring boot 3.0 or upper 버전에서 사용할 수 있는 개인 정보 마스킹 라이브러리


### 사용방법
```
@Convert(converter = NameConverter::class)
var name: String = name
```

마스킹이 필요한 필드에 Convert 어노테이션(jakarta)을 사용하고 사전에 구현된 converter를 넘겨주면 된다.

### 현재 구현된 converter
- NameConverter: 가운데 글자 마스킹
- PasswordConverter: 모든 글자 마스킹
- EmailCoverter: 첫 3글자 @뒤 1글자 마스킹
