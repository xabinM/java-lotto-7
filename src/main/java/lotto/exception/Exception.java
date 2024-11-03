package lotto.exception;

public enum Exception {
    FAIL_PARSE_INT("숫자만 입력 가능합니다"),
    INDIVISIBLE_PRICE("로또 구입 금액은 1000원 단위만 가능합니다."),
    INVALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("1이상 45이하의 숫자만 입력 가능합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_AND_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
