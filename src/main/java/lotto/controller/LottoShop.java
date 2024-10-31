package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoMachine;
import lotto.view.LottoView;

import java.util.List;

public class LottoShop {
    private final LottoView lottoView;
    private final LottoMachine lottoMachine;

    public LottoShop(LottoView lottoView, LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.lottoView = new LottoView();
    }

    public void runLotto() {
        int amount = processPurchaseAmount();
        processBuyLotto(amount);
    }

    public int processPurchaseAmount() {
        while (true) {
            try {
                return new LottoAmount(lottoView.requestPurchasePrice()).getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> processBuyLotto(int amount) {
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        lottoView.printLottos(lottos);
        return lottos;
    }
}
