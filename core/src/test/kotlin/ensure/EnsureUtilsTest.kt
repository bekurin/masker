package ensure

import constant.ProcessType.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class EnsureUtilsTest {

    @Nested
    inner class `이메일을 마스킹할 때` {
        @ParameterizedTest
        @CsvSource(
            value = [
                "test@gmail.com, tes*@g********",
                "qwe@naver.com, qwe@n********",
                "sampleEmail123@dawn.com, sam***********@d*******"
            ]
        )
        fun `첫자리 3자리, @앞1자리를 제외하고 마스킹한다`(input: String, expect: String) {
            // given & when
            val result = EnsureUtils.ensure(input, EMAIL)

            // then
            assertThat(result).isEqualTo(expect)
        }
    }

    @Nested
    inner class `이름을 마스킹할 때` {
        @ParameterizedTest
        @CsvSource(
            value = [
                "홍길동, 홍*동",
                "아무개, 아*개",
                "남궁암호, 남**호",
                "가나, 가*"
            ]
        )
        fun `가운데 글자를 마스킹한다`(input: String, expect: String) {
            // given & when
            val result = EnsureUtils.ensure(input, NAME)

            // then
            assertThat(result).isEqualTo(expect)
        }
    }

    @Nested
    inner class `비밀번호를 마스킹할 때` {
        @ParameterizedTest
        @CsvSource(
            value = [
                "2602as, ******",
                "2as505za, ********",
                "2411dsaw, ********",
            ]
        )
        fun `전체를 마스킹한다`(input: String, expect: String) {
            // given & when
            val result = EnsureUtils.ensure(input, PASSWORD)

            // then
            assertThat(result).isEqualTo(expect)
        }
    }
}
