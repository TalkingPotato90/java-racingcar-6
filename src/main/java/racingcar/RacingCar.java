package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.OutputController;

import java.util.*;

public class RacingCar {
    public void validateNameLength(List<String> inputName) {
        boolean isValid = inputName.stream().allMatch(s -> s.length() <= 5);
        if (!isValid) {
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
        inputNames = inputNames.replaceAll(" ", "");
        List<String> players = new ArrayList<>(Arrays.asList(inputNames.split(",")));
        return players;
    }

    public Map<String,Boolean> createMoveInformation(List<String> playersCar, List<Boolean> moves) {
        Map<String,Boolean> moveInformation = new HashMap<>();

        for (int i = 0; i < playersCar.size(); i++) {
            moveInformation.put(playersCar.get(i), moves.get(i));
        }

        return moveInformation;
    }

    public void printResult(Map<String,Boolean> moveInformation, List<String> playersCar) {
        for (int i = 0; i < moveInformation.size(); i++) {
            if (moveInformation.get(playersCar.get(i))) {
                OutputController.getInstance().appendResult(playersCar.get(i),"-");
            }
            System.out.println(playersCar.get(i) + ": " + OutputController.getInstance()
                    .getPosition(playersCar.get(i)));
        }
        System.out.println();
    }

    public String selectWinner(Map<String,Boolean> moveInformation) {
        String winner = "";

        int maxPosition = 0;

        for (String player : moveInformation.keySet()) {
            String currentPosition = OutputController.getInstance().getPosition(player);
            if (currentPosition.length() > maxPosition) {
                maxPosition = currentPosition.length();
                winner = player;
            }
        }

        return winner;
    }

}