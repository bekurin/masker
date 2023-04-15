class DefaultRegex {
    companion object {
        val email = Regex("(?<=.{3}).*(?=.{2}@)|(?<=.).(?=.@)|.(?=.@)")

        val username = Regex("")

        val password = Regex("")
    }
}