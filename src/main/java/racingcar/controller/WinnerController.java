package racingcar.controller;

import racingcar.util.Guide;
import racingcar.util.Value;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerController {
    private OutputView outputView = new OutputView();

    public void printResult(Map<String, Boolean> moveInformation, List<String> playersCar) {
        for (int i = 0; i < moveInformation.size(); i++) {
            String carName = playersCar.get(i);
            if (moveInformation.get(carName)) {
                OutputController.getInstance().appendResult(carName, Guide.MOVE.getMessage());
            }
            outputView.printRaceResult(carName);
        }
        outputView.printNextLine();
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
