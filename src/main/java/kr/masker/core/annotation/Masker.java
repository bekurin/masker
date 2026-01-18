package kr.masker.core.annotation;

import kr.masker.core.util.MaskerType;
import kr.masker.core.util.ReplaceStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Masker {
    MaskerType maskerType() default MaskerType.ALL;

    ReplaceStrategy strategy() default ReplaceStrategy.DEFAULT;
}
