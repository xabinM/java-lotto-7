package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.Exception.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ViewTest {
    @Nested
    class 구입금액_입력_테스트 extends NsTest {

        @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생되는가.")
        @Test
        void inputPrice() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("input"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
            });
        }

        @Override
        protected void runMain() {
            LottoView lottoView = new LottoView();
            lottoView.requestPurchasePrice();
        }
    }


}
