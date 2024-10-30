package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String ERROR_PARSE_INT = "[ERROR] 정수만 입력해 주세요.";


    public int requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        return inputPrice();
    }

    private int inputPrice() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PARSE_INT);
        }
    }

}
