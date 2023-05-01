package util

import constant.ProcessType

object EnsureUtils {
    fun ensure(input: CharSequence, type: ProcessType): String {
        return EnsureFactory.of(type).process(input)
    }
}
