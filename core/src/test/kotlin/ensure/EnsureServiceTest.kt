package ensure

import EnsureService
import constant.ProcessType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class EnsureServiceTest {
    private val ensureService = EnsureService()

    @Nested
    inner class `이메일을 마스킹 처리할 때` {
        @Nested
        inner class `이메일이 6자리 이상이면` {

            @ParameterizedTest
            @CsvSource(
                value = [
                    "test12@gmail.com, tes**2@gmail.com",
                    "test1234@gmail.com, tes****4@gmail.com",
                    "helloworld@naver.com, hel******d@naver.com",
                    "himynameiscoffee@daum.com, him************e@daum.com"
                ]
            )
            fun `앞에 3자리와 뒤에 2자리를 제외하고 마스킹한다`(origin: String, expect: String) {
                val result = ensureService.process(origin, ProcessType.EMAIL)
                assertThat(result).isEqualTo(expect)
            }
        }

        @Nested
        inner class `이메일이 5자리 이하라면` {
            @ParameterizedTest
            @CsvSource(
                value = [
                    "test1@gmail.com, tes*1@gmail.com",
                    "test@naver.com, te*t@naver.com",
                    "pos@domain.com, p*s@domain.com",
                    "hi@follow.com, h*@follow.com",
                    "h@hello.world, *@hello.world"
                ]
            )
            fun `중간을 계산하여 마스킹한다`(origin: String, expect: String) {
                val result = ensureService.process(origin, ProcessType.EMAIL)
                assertThat(result).isEqualTo(expect)
            }
        }
    }

    @Nested
    inner class `이름을 마스킹 처리할 때` {
        @Nested
        inner class `3글자 이상이면` {

            @ParameterizedTest
            @CsvSource(
                value = [
                    "홍길동, 홍*동",
                    "남궁민수, 남**수",
                    "아메리카노, 아***노"
                ]
            )
            fun `첫글자와 마지막 글자를 마스킹처리한다`(origin: String, expect: String) {
                val result = ensureService.process(origin, ProcessType.USERNAME)
                assertThat(result).isEqualTo(expect)
            }
        }

        @Nested
        inner class `2글자 이하라면` {
            @ParameterizedTest
            @CsvSource(
                value = [
                    "김가, 김*",
                    "박가, 박*",
                    "오가, 오*",
                    "이빨, 이*"
                ]
            )
            fun `마지막 글자를 마스킹처리한다`(origin: String, expect: String) {
                val result = ensureService.process(origin, ProcessType.USERNAME)
                assertThat(result).isEqualTo(expect)
            }
        }
    }

    @Nested
    inner class `비밀번호를 마스킹처리할 때` {
        @Nested
        inner class `길이에 상관하지 않고` {
            @ParameterizedTest
            @CsvSource(
                value = [
                    "password1234, ************",
                    "DWqdwR!#@EFDFwdsa, *****************",
                    "feq92qdjksafjwqd2, *****************"
                ]
            )
            fun `모든 글자를 마스킹처리한다`(origin: String, expect: String) {
                val result = ensureService.process(origin, ProcessType.PASSWORD)
                assertThat(result).isEqualTo(expect)
            }
        }
    }
}