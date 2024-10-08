package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.OutputController;
import racingcar.util.Guide;

import java.util.*;

public class RacingCar {
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
        List<String> players = new ArrayList<>(Arrays.asList(inputNames.split(Guide.SPLIT.getMessage())));
        return players;
    }

    public Map<String,Boolean> createMoveInformation(List<String> playersCar, List<Boolean> moves) {
        Map<String,Boolean> moveInformation = new LinkedHashMap<>();

        for (int i = 0; i < playersCar.size(); i++) {
            moveInformation.put(playersCar.get(i), moves.get(i));
        }

        return moveInformation;
    }

    public void printResult(Map<String,Boolean> moveInformation, List<String> playersCar) {
        for (int i = 0; i < moveInformation.size(); i++) {
            if (moveInformation.get(playersCar.get(i))) {
                OutputController.getInstance().appendResult(playersCar.get(i), Guide.MOVE.getMessage());
            }
            String result = playersCar.get(i) + Guide.COLON.getMessage() + OutputController.getInstance()
                    .getPosition(playersCar.get(i));
            System.out.println(result);
        }
        System.out.println();
    }

    public String selectWinner(List<String> playersCar) {
        List<String> winner = new ArrayList<>();

        int maxPosition = -1;

        for (String player : playersCar) {
            String currentPosition = OutputController.getInstance().getPosition(player);
            if (currentPosition.length() > maxPosition) {
                maxPosition = currentPosition.length();
                winner.clear();
                winner.add(player);
            } else if (currentPosition.length() == maxPosition) {
                winner.add(player);
            }
        }

        return String.join(Guide.JOIN.getMessage(), winner);
    }

}