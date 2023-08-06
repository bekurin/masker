package kr.masker.core.util;

public enum MaskerUtil {
    ;

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
