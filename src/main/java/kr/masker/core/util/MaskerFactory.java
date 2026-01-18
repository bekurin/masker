package kr.masker.core.util;

import kr.masker.core.*;

import java.util.Map;

public enum MaskerFactory {
    ;

    @FunctionalInterface
    interface MaskerCreator {
        Masker create(Replacement replacement, ReplaceStrategy strategy);
    }

    private static final Map<MaskerType, MaskerCreator> MASKER_MAP = Map.of(
            MaskerType.NAME, NameMasker::new,
            MaskerType.PHONE, PhoneMasker::new,
            MaskerType.EMAIL, EmailMasker::new,
            MaskerType.PASSWORD, PasswordMasker::new,
            MaskerType.ALL, AllMasker::new
    );

    public static Masker of(MaskerType maskerType, Replacement replacement, ReplaceStrategy strategy) {
        MaskerCreator creator = MASKER_MAP.get(maskerType);
        if (creator == null) {
            throw new IllegalArgumentException("Unsupported masker type: " + maskerType);
        }
        return creator.create(replacement, strategy);
    }
}
