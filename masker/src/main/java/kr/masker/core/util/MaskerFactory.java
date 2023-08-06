package kr.masker.core.util;

import kr.masker.core.*;

public enum MaskerFactory {
    ;

    /**
     * FIXME: 마스킹 관련 파라미터를 가지는 객체를 생성한다.
     * 1. Masker를 부모 클래스로 정의하여 Masker의 Replacement, Strategy 설정에 따라서 마스킹 처리가 다르게 되도록 설정
     * 2. strategy에 따른 구현 클래스를 만든다.
     * 3. 전략 패턴을 적용한다.
     */
    public static Masker of(MaskerType maskerType, Replacement replacement, ReplaceStrategy strategy) {
        if (maskerType.equals(MaskerType.NAME)) {
            return new NameMasker(replacement, strategy);
        } else if (maskerType.equals(MaskerType.PHONE)) {
            return new PhoneMasker(replacement, strategy);
        } else if (maskerType.equals(MaskerType.EMAIL)) {
            return new EmailMasker(replacement, strategy);
        } else if (maskerType.equals(MaskerType.PASSWORD)) {
            return new PasswordMasker(replacement, strategy);
        } else if (maskerType.equals(MaskerType.ALL)) {
            return new AllMasker(replacement, strategy);
        }
        throw new RuntimeException("undefined masker type.");
    }
}
