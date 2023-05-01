package ensure

import constant.Value

class NameEnsure: Ensure {
    override fun process(input: CharSequence): String {
        val regex = if (input.length < 3) {
            Regex(RegexExpression.NAME_LESS_THAN_THREE)
        } else {
            Regex(RegexExpression.NAME_NOT_LESS_THAN_THREE)
        }
        return regex.replace(input, Value.REPLACEMENT)
    }
}
