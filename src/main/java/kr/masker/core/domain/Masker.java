package kr.masker.core.domain;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public abstract class Masker {
    protected final Replacement replacement;
    protected final ReplaceStrategy replaceStrategy;

    protected Masker(Replacement replacement, ReplaceStrategy replaceStrategy) {
        this.replacement = replacement;
        this.replaceStrategy = replaceStrategy;
    }

    public String process(CharSequence input) {
        if (replaceStrategy.equals(ReplaceStrategy.DEFAULT)) {
            return getMaskingUsingDefault(input);
        } else if (replaceStrategy.equals(ReplaceStrategy.ONE)) {
            return getMaskingUsingOne();
        }
        throw new RuntimeException("undefined replace strategy " + replaceStrategy.name());
    }

    protected String getMaskingUsingDefault(CharSequence input) {
        return Pattern
                .compile(RegexExpression.ALL.getValue())
                .matcher(input)
                .replaceAll(replacement.getValue());
    }

    protected String getMaskingUsingOne() {
        return replacement.getValue();
    }
}
