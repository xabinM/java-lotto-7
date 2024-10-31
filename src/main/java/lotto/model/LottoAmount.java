package lotto.model;

import static lotto.exception.Exception.INDIVISIBLE_PRICE;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoAmount(int amount) {
        validateDivisibility(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateDivisibility(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INDIVISIBLE_PRICE.getMessage());
        }
    }
}
