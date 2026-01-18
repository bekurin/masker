package kr.masker.core.util;

public enum RegexExpression {
    EMAIL("(?<=.{3}).(?<!@.?)"),
    PHONE("(?<=.{3}).(?=.{4})"),
    NAME_LESS_THAN_THREE("(.)$"),
    NAME_GREATER_THAN_OR_EQUAL_THREE("(?<=.).(?=.)"),
    ALL(".");
    private final String value;

    RegexExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
