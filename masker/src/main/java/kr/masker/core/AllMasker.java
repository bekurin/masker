package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class AllMasker implements Masker {
    @Override
    public String process(CharSequence input) {
        return Pattern
                .compile(RegexExpression.ALL.getValue())
                .matcher(input)
                .replaceAll(Replacement.ASTERISK.getValue());
    }
}
