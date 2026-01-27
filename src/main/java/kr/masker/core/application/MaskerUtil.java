package kr.masker.core.application;

import kr.masker.core.util.MaskerType;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;

public class MaskerUtil {

    public static String process(String value, MaskerType maskerType, Replacement replacement, ReplaceStrategy replaceStrategy) {
        return MaskerFactory
                .of(maskerType, replacement, replaceStrategy)
                .process(value);
    }

    public static String process(String value, MaskerType maskerType, Replacement replacement) {
        return MaskerFactory
                .of(maskerType, replacement, ReplaceStrategy.DEFAULT)
                .process(value);
    }
}
