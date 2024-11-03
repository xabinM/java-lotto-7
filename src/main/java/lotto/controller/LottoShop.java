package lotto.controller;

import lotto.model.*;
import lotto.view.LottoView;
import java.util.List;

public class LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void runLotto() {
        int amount = processPurchaseAmount();
        List<Lotto> lottos = processBuyLotto(amount);
        WinningLotto winningLotto = processWinningLotto();
        processWinningStatistics(lottos, winningLotto);
    }

    private int processPurchaseAmount() {
        while (true) {
            try {

                return new LottoAmount(LottoView.requestPurchasePrice()).getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> processBuyLotto(int amount) {
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        LottoView.printLottos(lottos);

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

                return LottoView.requestWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int drawBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {

                return LottoView.requestBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void processWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = StatisticsCalculator.checkLotto(lottos, winningLotto);

        RankStorage rankStorage = new RankStorage();
        StatisticsCalculator.calculateRankCounts(lottoResults, rankStorage);

        LottoView.printWinningStatistics(rankStorage);
    }
}
