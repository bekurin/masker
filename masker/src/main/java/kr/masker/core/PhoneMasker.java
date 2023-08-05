package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class PhoneMasker implements Masker {
    @Override
    public String process(CharSequence input, Replacement replacement) {
        return Pattern
                .compile(RegexExpression.PHONE.getValue())
                .matcher(input)
                .replaceAll(replacement.getValue());
    }
}
