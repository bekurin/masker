package kr.masker.core.domain;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class PhoneMasker extends Masker {

    public PhoneMasker(Replacement replacement, ReplaceStrategy replaceStrategy) {
        super(replacement, replaceStrategy);
    }

    @Override
    protected String getMaskingUsingDefault(CharSequence input) {
        return Pattern
                .compile(RegexExpression.PHONE.getValue())
                .matcher(input)
                .replaceAll(replacement.getValue());
    }
}
