package lotto.model.validator;

import lotto.exception.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator extends NumberRangeValidator {
    public static void validateWinningNumbers (List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateNumberRange(numbers);
        validateWinningNumberDuplication(numbers);
    }

    private static void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    Exception.IVALID_LOTTO_NUMBERS_SIZE.getMessage()
            );
        }
    }

    private static void validateWinningNumberDuplication(List<Integer> numbers) {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);

        if (duplicationCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(Exception.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

}
