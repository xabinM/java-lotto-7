package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoNumberGenerator;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoMachine = new LottoShop(
                new LottoView(), new LottoMachine(new LottoNumberGenerator()));
        lottoMachine.runLotto();
    }
}
