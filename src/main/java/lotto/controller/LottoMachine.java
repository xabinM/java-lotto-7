package lotto.controller;

import lotto.model.Lotto;
import lotto.model.validator.Validator;
import lotto.view.LottoView;

import java.util.List;

public class LottoMachine {
    private final LottoView lottoView;

    public LottoMachine(LottoView lottoView) {
        this.lottoView = new LottoView();
    }

    public void runLotto() {
        int price = processPurchaseAmount();
    }

    public int processPurchaseAmount() {
        while (true) {
            try {
                int purchasePrice = lottoView.requestPurchasePrice();
                Validator.validateDivisibility(purchasePrice);

                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
