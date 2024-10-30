package lotto.controller;

import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoView());
        lottoMachine.runLotto();
    }
}
