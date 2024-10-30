package lotto.model.validator;


import static lotto.exception.Exception.INDIVISIBLE_PRICE;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static void validateDivisibility(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INDIVISIBLE_PRICE.getMessage());
        }
    }
}
