package racingcar.view;

import racingcar.controller.OutputController;
import racingcar.util.Guide;

public class OutputView {
    public void print(String message) {
        System.out.println(message);
    }

    public void printRaceResult(String player) {
        String result = player + Guide.COLON.getMessage() + OutputController.getInstance().getPosition(player);
        System.out.println(result);
    }

    public void printNextLine() {
        System.out.println();
    }
}
