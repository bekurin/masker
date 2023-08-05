package kr.masker.core.util;

public enum MaskerType {
    ALL("전체 마스킹"),
    NAME("이름"),
    EMAIL("이메일"),
    PHONE("전화번호"),
    PASSWORD("비밀번호");

    MaskerType(String description) {
    }
}
