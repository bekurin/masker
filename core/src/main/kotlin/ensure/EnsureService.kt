import kotlin.math.abs
import kotlin.text.Regex

class EnsureService {

    fun email(origin: String, regex: Regex = DefaultRegex.email): String {
        val matchingRange = regex.find(origin)?.range ?: throw RuntimeException("$origin 매칭 되는 부분이 없습니다")
        return origin.replaceRange(matchingRange, getReplacement(matchingRange))
    }

    fun password(origin: String, regex: Regex = DefaultRegex.password) {

    }

    fun username(origin: String, regex: Regex = DefaultRegex.username) {

    }

    private fun getReplacement(matchingRange: IntRange): String {
        val repeat = abs(matchingRange.last - matchingRange.first)
        return if (repeat == 0) {
            "*"
        } else {
            "*".repeat(repeat)
        }
    }
}