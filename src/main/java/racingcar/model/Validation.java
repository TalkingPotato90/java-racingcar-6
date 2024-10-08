package racingcar.model;

import racingcar.util.Guide;
import racingcar.util.Value;

import java.util.List;

public class Validation {
    public void validateNameLength(List<String> inputName) {
        boolean isValid = inputName.stream().allMatch(s -> s.length() <= Value.NAME_LENGTH_MAX.getNumber());
        if (!isValid) {
            throw new IllegalArgumentException(Guide.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void validateTryCounts(String inputCounts) {
        if (!inputCounts.matches(Guide.ONLY_DIGIT.getMessage())) {
            throw new IllegalArgumentException(Guide.TRY_COUNT_FORMAT_ERROR.getMessage());
        }

        if (Integer.parseInt(inputCounts) > Value.TRY_COUNT_MAX.getNumber()) {
            throw new IllegalArgumentException(Guide.TRY_COUNT_MAX_VALUE_ERROR.getMessage());
        }
    }
}
