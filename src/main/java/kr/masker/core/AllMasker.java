package kr.masker.core;

import kr.masker.core.util.RegexExpression;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

import java.util.regex.Pattern;

public class AllMasker extends Masker {

    public AllMasker(Replacement replacement, ReplaceStrategy replaceStrategy) {
        super(replacement, replaceStrategy);
    }

    @Override
    protected String getMaskingUsingDefault(CharSequence input) {
        return Pattern
                .compile(RegexExpression.ALL.getValue())
                .matcher(input)
                .replaceAll(replacement.getValue());
    }
}
