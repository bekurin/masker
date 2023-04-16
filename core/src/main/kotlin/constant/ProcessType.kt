package constant

import DefaultRegex

enum class ProcessType {
    EMAIL, USERNAME, PASSWORD;

    fun toRegex(): Regex {
        return when (this) {
            EMAIL -> DefaultRegex.email
            USERNAME -> DefaultRegex.username
            PASSWORD -> DefaultRegex.password
        }
    }
}