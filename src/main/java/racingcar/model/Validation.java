package racingcar.model;

import racingcar.util.Guide;

import java.util.List;

public class Validation {
    public void validateNameLength(List<String> inputName) {
        boolean isValid = inputName.stream().allMatch(s -> s.length() <= 5);
        if (!isValid) {
            throw new IllegalArgumentException(Guide.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void validateTryCounts(String inputCounts) {
        if (!inputCounts.matches(Guide.ONLY_DIGIT.getMessage())) {
            throw new IllegalArgumentException(Guide.TRY_COUNT_FORMAT_ERROR.getMessage());
        }

        if (Integer.parseInt(inputCounts) > 10) {
            throw new IllegalArgumentException(Guide.TRY_COUNT_MAX_VALUE_ERROR.getMessage());
        }
    }
}
