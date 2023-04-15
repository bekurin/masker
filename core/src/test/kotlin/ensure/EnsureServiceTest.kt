package ensure

import EnsureService
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EnsureServiceTest {
    private val ensureService = EnsureService()

    @Nested
    inner class `이메일을 마스킹 처리할 때` {
        @Nested
        inner class `이메일이 6자리 이상이라면` {

            @ParameterizedTest
            @ValueSource(
                strings = [
                    "test1234@gmail.com",
                    "helloworld@naver.com",
                    "himynameiscoffee@daum.com",
                    "test@gmail.com"
                ]
            )
            fun `앞에 3자리와 뒤에 2자리를 제외하고 마스킹한다`(origin: String) {
                val result = ensureService.email(origin)
                println(result)
            }
        }

        @Nested
        inner class `이메일이 5자리 이하라면` {
            @ParameterizedTest
            @ValueSource(
                strings = [
                    "test12@gmail.com",
                    "test@naver.com",
                    "pos@domain.com",
                    "hi@follow.com"
                ]
            )
            fun `마스킹한다`(origin: String) {
                val result = ensureService.email(origin)
                println(result)
            }
        }
    }
}