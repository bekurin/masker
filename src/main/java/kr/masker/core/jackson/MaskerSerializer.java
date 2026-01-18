package kr.masker.core.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kr.masker.core.annotation.Masker;
import kr.masker.core.util.MaskerUtil;

import java.io.IOException;

public class MaskerSerializer extends JsonSerializer<Object> {
    private final Masker masker;

    public MaskerSerializer(Masker masker) {
        this.masker = masker;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(MaskerUtil.process(value.toString(), masker.maskerType(), masker.replacement(), masker.strategy()));
    }
}
