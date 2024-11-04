package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());

    @DisplayName("로또 금액에 맞게 올바른 수량의 로또가 발행되는가.")
    @Test
    void createLottosByLottoAmount() {
        int lottoPrice = 1000;
        int lottoQuantity = 10;

        assertThat(lottoMachine.buyLottos(new LottoAmount(lottoPrice * lottoQuantity).getAmount()))
                .hasSize(lottoQuantity);
    }
}
