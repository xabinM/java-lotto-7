package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.validator.BonusValidator;
import lotto.model.validator.WinningNumbersValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.Exception.FAIL_PARSE_INT;

public class LottoView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_PURCHASE_RESULT = "개를 구매했습니다.";
    private static final String DELIMITER_WINNING_NUMBERS = ",";

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

    public List<Integer> requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        List<Integer> numbers = inputWinningNumbers();
        WinningNumbersValidator.validateWinningNumbers(numbers);

        return numbers;
    }

    private List<Integer> inputWinningNumbers() {
        String input = Console.readLine();

        return parseToInteger(input.split(DELIMITER_WINNING_NUMBERS));
    }

    private List<Integer> parseToInteger(String[] splitedInput) {
        List<Integer> winningNumbers = new ArrayList<>();

        try {
            for (String number : splitedInput) {
                winningNumbers.add(Integer.parseInt(number.trim()));
            }

            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FAIL_PARSE_INT.getMessage());
        }
    }
}
