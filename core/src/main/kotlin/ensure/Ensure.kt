package ensure

interface Ensure {
    fun process(input: CharSequence): String
}
