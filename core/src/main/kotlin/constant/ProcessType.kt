package constant

enum class ProcessType(
    private val description: String
) {
    EMAIL("이메일"),
    NAME("이름"),
    PASSWORD("비밀번호");

}
