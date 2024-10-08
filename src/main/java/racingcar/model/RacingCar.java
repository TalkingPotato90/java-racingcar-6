package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.OutputController;
import racingcar.util.Guide;
import racingcar.util.Value;

import java.util.*;

public class RacingCar {

    public List<Integer> createRandomNumber(int player) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < player; i++) {
            numbers.add(Randoms.pickNumberInRange(Value.RANDOM_MIN.getNumber(), Value.RANDOM_MAX.getNumber()));
        }

        return numbers;
    }

    public List<Boolean> createMove(List<Integer> randomNumbers) {
        List<Boolean> moves = new ArrayList<>();

        for (Integer randomNumber : randomNumbers) {
            moves.add(randomNumber >= Value.MOVE_BASE.getNumber());
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

    public String selectWinner(List<String> playersCar) {
        List<String> winner = new ArrayList<>();

        int maxPosition = Value.DEFAULT_POSITION.getNumber();

        for (String player : playersCar) {
            String currentPosition = OutputController.getInstance().getPosition(player);
            boolean isSoloWin = currentPosition.length() > maxPosition;

            if (isSoloWin) {
                maxPosition = currentPosition.length();
                winner.clear();
                winner.add(player);
            }

            if (currentPosition.length() == maxPosition && !isSoloWin) {
                winner.add(player);
            }
        }

        return String.join(Guide.JOIN.getMessage(), winner);
    }

}