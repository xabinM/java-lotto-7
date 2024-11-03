package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.*;
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
    private static final String PRINT_WINNING_STATISTICS = "당첨 통계";
    private static final String PRINT_SECTION_SEPARATOR = "---";

    public static int requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);

        return inputPrice();
    }

    private static int inputPrice() {
        try {

            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FAIL_PARSE_INT.getMessage());
        }
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_PURCHASE_RESULT);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        List<Integer> numbers = inputWinningNumbers();
        WinningNumbersValidator.validateWinningNumbers(numbers);

        return numbers;
    }

    private static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();

        return parseToInteger(input.split(DELIMITER_WINNING_NUMBERS));
    }

    private static List<Integer> parseToInteger(String[] splitedInput) {
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

    public static int requestBonusNumber(List<Integer> winningNumbers) {
        System.out.println(REQUEST_BONUS_NUMBER);
        int number = inputBonusNumber();
        BonusValidator.validateBonusNumber(number, winningNumbers);

        return number;
    }

    private static int inputBonusNumber() {
        try {
            String input = Console.readLine();

            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FAIL_PARSE_INT.getMessage());
        }
    }

    public static void printWinningStatistics(LottoAmount lottoAmount, RankStorage rankStorage) {
        System.out.println(PRINT_WINNING_STATISTICS);
        System.out.println(PRINT_SECTION_SEPARATOR);

        printStatisticsDetails(rankStorage);
        printRateReturn(lottoAmount, rankStorage);
    }

    private static void printStatisticsDetails(RankStorage rankStorage) {
        for (RankMessage rankMessage : RankMessage.values()) {
            int rank = rankMessage.getRank();
            String winningMessage = rankMessage.getWinningMessage();
            int count = rankStorage.getRankCount(rank);

            System.out.println(winningMessage + " - " + count + "개");
        }
    }

    private static void printRateReturn(LottoAmount lottoAmount, RankStorage rankStorage) {
        System.out.println("총 수익률은 " +
                StatisticsCalculator.calculateRateReturn(lottoAmount, rankStorage) +
                "%입니다.");
    }
}
