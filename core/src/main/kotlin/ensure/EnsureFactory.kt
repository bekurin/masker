package ensure

import constant.ProcessType

object EnsureFactory {
    fun of(type: ProcessType): Ensure {
        return when (type) {
            ProcessType.NAME -> NameEnsure()
            ProcessType.PASSWORD -> PasswordEnsure()
            ProcessType.EMAIL -> EmailEnsure()
        }
    }
}
