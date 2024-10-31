package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoMachine;
import lotto.model.WinningLotto;
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
        List<Lotto> lottos = processBuyLotto(amount);
        WinningLotto winningLotto = processWinningLotto();
    }

    private int processPurchaseAmount() {
        while (true) {
            try {

                return new LottoAmount(lottoView.requestPurchasePrice()).getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> processBuyLotto(int amount) {
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        lottoView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto processWinningLotto() {
        List<Integer> winningNumbers = drawWinningNumbers();
        int bonusNumber = drawBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> drawWinningNumbers() {
        while (true) {
            try {

                return lottoView.requestWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int drawBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {

                return lottoView.requestBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
