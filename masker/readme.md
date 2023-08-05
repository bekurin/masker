# Masker

annotation based masking for spring boot project and easily apply masking for name, password, email, phone etc

## usage

there is two choice of apply Masker library to your project.

if Jackson2ObjectMapperBuilderCustomizer bean exists in your project.
follow below process

### java

```java

```

### kotlin

```kotlin

```

if Jackson2ObjectMapperBuilderCustomizer bean does not exist in your project.
follow below process

### java

```yaml
# application.yml
masker:
  active: true
```

### kotlin

```yaml
# application.yml
masker:
  active: true
```

## compatibility version
- spring boot version:
- jdk version:
