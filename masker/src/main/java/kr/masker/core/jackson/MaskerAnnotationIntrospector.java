package kr.masker.core.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import kr.masker.core.annotation.Masker;

public class MaskerAnnotationIntrospector extends JacksonAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated am) {
        Masker masker = am.getAnnotation(Masker.class);
        if (masker == null) {
            return super.findSerializer(am);
        }
        return new MaskerSerializer(masker);
    }

}
