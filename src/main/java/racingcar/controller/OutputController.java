package racingcar.controller;

import java.util.HashMap;
import java.util.Map;

public class OutputController {
    private static OutputController outputController;
    private Map<String, StringBuilder> positions;

    private OutputController() {
        positions = new HashMap<>();
    }

    public static synchronized OutputController getInstance() {
        if (outputController == null) {
            outputController = new OutputController();
        }

        return outputController;
    }

    public void appendResult(String carName, String move) {
        positions.putIfAbsent(carName, new StringBuilder());
        positions.get(carName).append(move);
    }

    public String getPosition(String carName) {
        return positions.getOrDefault(carName, new StringBuilder()).toString();
    }
}
