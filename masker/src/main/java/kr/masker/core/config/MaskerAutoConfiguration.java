package kr.masker.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.masker.core.jackson.MaskerAnnotationIntrospector;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@AutoConfiguration(after = JacksonAutoConfiguration.class)
@ConditionalOnClass(ObjectMapper.class)
@ConditionalOnProperty(prefix = "masker", name = "active", havingValue = "true")
public class MaskerAutoConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer maskerJackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.annotationIntrospector(new MaskerAnnotationIntrospector());
    }
}
