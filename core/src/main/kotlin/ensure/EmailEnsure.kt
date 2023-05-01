package ensure

import RegexExpression
import constant.Value

class EmailEnsure : Ensure {
    override fun process(input: CharSequence): String {
        val regex = Regex(RegexExpression.EMAIL)
        return regex.replace(input, Value.REPLACEMENT)
    }
}
