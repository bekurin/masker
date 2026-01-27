package kr.masker.core.integration.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kr.masker.core.integration.annotation.Masker;
import kr.masker.core.application.MaskerUtil;
import kr.masker.core.util.Replacement;

import java.io.IOException;

public class MaskerSerializer extends JsonSerializer<Object> {
    private final Masker masker;
    private final Replacement replacement;

    public MaskerSerializer(Masker masker, Replacement replacement) {
        this.masker = masker;
        this.replacement = replacement;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(MaskerUtil.process(value.toString(), masker.maskerType(), replacement, masker.strategy()));
    }
}
