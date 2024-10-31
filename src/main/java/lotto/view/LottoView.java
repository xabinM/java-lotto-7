package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;

import static lotto.exception.Exception.FAIL_PARSE_INT;

public class LottoView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_PURCHASE_RESULT = "개를 구매했습니다.";

    public int requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        return inputPrice();
    }

    private int inputPrice() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FAIL_PARSE_INT.getMessage());
        }
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_PURCHASE_RESULT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
