package kr.masker.core.domain;

import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

public abstract class Masker {

    protected final Replacement replacement;
    protected final ReplaceStrategy replaceStrategy;

    protected Masker(Replacement replacement, ReplaceStrategy replaceStrategy) {
        this.replacement = replacement;
        this.replaceStrategy = replaceStrategy;
    }

    public String process(CharSequence input) {
        if (replaceStrategy.equals(ReplaceStrategy.DEFAULT)) {
            return mask(input);
        } else if (replaceStrategy.equals(ReplaceStrategy.ONE)) {
            return mask();
        }
        throw new RuntimeException("undefined replace strategy " + replaceStrategy.name());
    }

    protected String mask() {
        return replacement.getValue();
    }

    protected abstract String mask(CharSequence input);
}
