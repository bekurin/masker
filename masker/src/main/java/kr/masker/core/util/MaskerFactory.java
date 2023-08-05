package kr.masker.core.util;

import kr.masker.core.*;

public enum MaskerFactory {
    ;
    public static Masker of(MaskerType maskerType) {
        if (maskerType.equals(MaskerType.NAME)) {
            return new NameMasker();
        } else if (maskerType.equals(MaskerType.PHONE)) {
            return new PasswordMasker();
        } else if (maskerType.equals(MaskerType.EMAIL)) {
            return new EmailMasker();
        } else if (maskerType.equals(MaskerType.PASSWORD)) {
            return new PasswordMasker();
        } else if (maskerType.equals(MaskerType.ALL)) {
            return new AllMasker();
        }
        throw new RuntimeException("undefined masker type.");
    }
}
