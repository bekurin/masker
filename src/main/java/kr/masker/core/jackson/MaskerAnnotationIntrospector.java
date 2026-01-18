package kr.masker.core.jackson;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import kr.masker.core.annotation.Masker;
import kr.masker.core.annotation.MaskerReplacement;
import kr.masker.core.util.Replacement;

public class MaskerAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated am) {
        Masker masker = am.getAnnotation(Masker.class);
        if (masker == null) {
            return super.findSerializer(am);
        }

        Replacement replacement = Replacement.ASTERISK;
        if (am instanceof AnnotatedMember) {
            Class<?> declaringClass = ((AnnotatedMember) am).getDeclaringClass();
            MaskerReplacement replacementAnnotation = declaringClass.getAnnotation(MaskerReplacement.class);
            if (replacementAnnotation != null) {
                replacement = replacementAnnotation.value();
            }
        }

        return new MaskerSerializer(masker, replacement);
    }
}
