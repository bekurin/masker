package kr.masker.core.util;

public enum MaskerUtil {
    ;

    public static String process(String value, MaskerType maskerType, Replacement replacement) {
        return MaskerFactory
                .of(maskerType)
                .process(value, replacement);
    }
}
