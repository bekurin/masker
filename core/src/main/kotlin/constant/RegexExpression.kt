object RegexExpression {
    const val EMAIL: String = "(?<=.{3}).(?<!@.?)"
    const val PHONE: String = "(?<=.{3}).(?=.{4})"
    const val NAME_LESS_THAN_THREE: String = "(.)\$"
    const val NAME_NOT_LESS_THAN_THREE: String = "(?<=.).(?=.)"
    const val SELECT_ALL: String = "."
}
