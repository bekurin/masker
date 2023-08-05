package kr.masker.core.config;

import kr.masker.core.jackson.MaskerAnnotationIntrospector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaskerConfig {
    @Bean(name = "jackson2ObjectMapperBuilderCustomizer")
    @ConditionalOnProperty(prefix = "masker", name = "active", havingValue = "true")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.annotationIntrospector(new MaskerAnnotationIntrospector());
    }
}
