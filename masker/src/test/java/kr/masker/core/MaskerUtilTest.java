package kr.masker.core;

import kr.masker.core.util.MaskerType;
import kr.masker.core.util.MaskerUtil;
import kr.masker.core.util.ReplaceStrategy;
import kr.masker.core.util.Replacement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class MaskerUtilTest {

    @ParameterizedTest
    @CsvSource(value = {
            "01011112222, 010****2222",
            "01033334444, 010****4444"
    })
    public void 핸드폰_번호_마스킹_처리할_때_가운데_자리_3자리만_마스킹처리된다(String input, String expect) {
        // given
        MaskerType givenMaskerType = MaskerType.PHONE;
        Replacement givenReplacement = Replacement.ASTERISK;

        // when
        String maskedPhone = MaskerUtil.process(input, givenMaskerType, givenReplacement);

        // then
        assertThat(maskedPhone).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "test@gmail.com, tes*@g********",
            "test123@naver.com, tes****@n********",
            "test123123@sample.com, tes*******@s*********"
    })
    @DisplayName("이메일 마스킹 처리를 할 때 @ 앞 1자리와 @ 뒤 1자리 이후 정보를 마스킹 처리한다.")
    public void emailMaskerTest(String input, String expect) {
        // given
        MaskerType givenMaskerType = MaskerType.EMAIL;
        Replacement givenReplacement = Replacement.ASTERISK;

        // when
        String maskedEmail = MaskerUtil.process(input, givenMaskerType, givenReplacement);

        // then
        assertThat(maskedEmail).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "홍길동, 홍*동",
            "홍현, 홍*",
            "james, j***s"
    })
    @DisplayName("이름을 마스킹할 때 2자리 이하라면 마지막 글자를 3자리 이상이라면 맨 앞, 뒤를 제외한 모든 글자를 마스킹 처리한다")
    public void nameMaskerTest(String input, String expect) {
        // given
        MaskerType givenMaskerType = MaskerType.NAME;
        Replacement givenReplacement = Replacement.ASTERISK;

        // when
        String maskedName = MaskerUtil.process(input, givenMaskerType, givenReplacement);

        // then
        assertThat(maskedName).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123123123, *********",
            "password123, ***********",
    })
    @DisplayName("비밀번호를 마스킹 처리할 때 자릿수에 맞게 모든 문자를 대체자로 변경한다")
    public void passwordMaskerTest(String input, String expect) {
        // given
        MaskerType givenMaskerType = MaskerType.PASSWORD;
        Replacement givenReplacement = Replacement.ASTERISK;

        // when
        String maskedPassword = MaskerUtil.process(input, givenMaskerType, givenReplacement);

        // then
        assertThat(maskedPassword).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123123, *",
            "test@gmail.com, *"
    })
    @DisplayName("ONE 전략을 선택하면 어떤 값이든 대체자 1개를 반환한다")
    public void OneStrategyTest(String input, String expect) {
        // given
        MaskerType givenMaskerType = MaskerType.ALL;
        Replacement givenReplacement = Replacement.ASTERISK;
        ReplaceStrategy givenReplaceStrategy = ReplaceStrategy.ONE;

        // when
        String maskedValue = MaskerUtil.process(input, givenMaskerType, givenReplacement, givenReplaceStrategy);

        // then
        assertThat(maskedValue).isEqualTo(expect);
    }
}
