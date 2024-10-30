package lotto.model.validator;

public class Validator {
    private static final int PRICE_UNIT = 1000;
    private static final String ERROR_INDIVISIBLE_PRICE = "[ERROR] 로또 구입 금액은 1000원 단위만 가능합니다.";

    public static void validateDivisibility(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_INDIVISIBLE_PRICE);
        }
    }
}
