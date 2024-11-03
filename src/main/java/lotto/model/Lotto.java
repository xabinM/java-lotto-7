package lotto.model;

import lotto.exception.Exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
