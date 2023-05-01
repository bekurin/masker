package util

import constant.ProcessType
import ensure.EmailEnsure
import ensure.Ensure
import ensure.NameEnsure
import ensure.PasswordEnsure

object EnsureFactory {
    fun of(type: ProcessType): Ensure {
        return when (type) {
            ProcessType.NAME -> NameEnsure()
            ProcessType.PASSWORD -> PasswordEnsure()
            ProcessType.EMAIL -> EmailEnsure()
        }
    }
}
