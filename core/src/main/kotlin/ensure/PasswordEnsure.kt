package ensure

import RegexExpression
import constant.Value

class PasswordEnsure : Ensure {
    override fun process(input: CharSequence): String {
        val regex = Regex(RegexExpression.SELECT_ALL)
        return regex.replace(input, Value.REPLACEMENT)
    }
}
