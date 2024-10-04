package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCar {
    public void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 각 이름의 길이는 5자 이내로 가능합니다.");
        }
    }

    public void validateTryCounts(String inputCounts) {
        if (!inputCounts.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자만 입력가능합니다.");
        }

        if (Integer.parseInt(inputCounts) > 10) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 10회 이하로만 가능합니다.");
        }
    }

    public List<Integer> createRandomNumber(int player) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < player; i++) {
            numbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return numbers;
    }

    public List<Boolean> createMove(List<Integer> randomNumbers) {
        List<Boolean> moves = new ArrayList<>();

        for (Integer randomNumber : randomNumbers) {
            moves.add(randomNumber >= 4);
        }

        return moves;
    }

    public List<String> createPlayersCar(String inputNames) {
        List<String> players = new ArrayList<>(Arrays.asList(inputNames.split(",")));
        return players;
    }
}