package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class NameMasker implements Masker {
    @Override
    public String process(CharSequence input) {
        return getPattern(input)
                .matcher(input)
                .replaceAll(Replacement.ASTERISK.getValue());
    }

    private Pattern getPattern(CharSequence input) {
        if (input.length() < 3) {
            return Pattern
                    .compile(RegexExpression.NAME_LESS_THAN_THREE.getValue());
        }
        return Pattern
                .compile(RegexExpression.NAME_GRATER_THAN_OR_EQUAL_THREE.getValue());
    }
}
