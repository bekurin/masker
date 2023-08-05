package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class EmailMasker implements Masker {
    @Override
    public String process(CharSequence input) {
        return Pattern
                .compile(RegexExpression.EMAIL.getValue())
                .matcher(input)
                .replaceAll(Replacement.ASTERISK.getValue());
    }
}
