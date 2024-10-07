package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserInput() {
        String carNames = Console.readLine();

        return carNames;
    }

    public String getTryCounts() {
        String tryCounts = Console.readLine();
        return tryCounts;
    }
}
