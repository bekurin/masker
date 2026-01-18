package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class NameMasker extends Masker {
    public NameMasker(Replacement replacement, ReplaceStrategy replaceStrategy) {
        super(replacement, replaceStrategy);
    }

    @Override
    protected String getMaskingUsingDefault(CharSequence input) {
        return getPattern(input)
                .matcher(input)
                .replaceAll(replacement.getValue());
    }

    private Pattern getPattern(CharSequence input) {
        if (input.length() < 3) {
            return Pattern
                    .compile(RegexExpression.NAME_LESS_THAN_THREE.getValue());
        }
        return Pattern
                .compile(RegexExpression.NAME_GREATER_THAN_OR_EQUAL_THREE.getValue());
    }
}
