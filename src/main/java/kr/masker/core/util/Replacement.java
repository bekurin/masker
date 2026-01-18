package kr.masker.core.util;

public enum Replacement {
    ASTERISK("*"),
    SHARP("#");

    private final String value;

    Replacement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
