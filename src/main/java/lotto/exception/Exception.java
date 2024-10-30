package lotto.exception;

public enum Exception {
    INDIVISIBLE_PRICE("로또 구입 금액은 1000원 단위만 가능합니다."),
    FAIL_PARSE_INT("숫자만 입력 가능합니다"),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
