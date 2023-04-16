import constant.ProcessType
import kotlin.math.abs

class EnsureService {
    companion object {
        const val REPLACEMENT = "*"
    }

    fun process(origin: String, processType: ProcessType): String {
        println()
        val matchingRange = getMatchingRange(origin, processType.toRegex())
        return origin.replaceRange(matchingRange, getReplacement(matchingRange))
    }

    private fun getMatchingRange(origin: String, regex: Regex): IntRange {
        return regex.find(origin)?.range ?: throw RuntimeException("$origin 매칭 되는 부분이 없습니다")
    }

    private fun getReplacement(matchingRange: IntRange): String {
        val repeat = abs(matchingRange.last - matchingRange.first) + 1
        return REPLACEMENT.repeat(repeat)
    }
}