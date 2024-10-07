package racingcar.controller;

public class OutputController {
    private static OutputController outputController;

    private StringBuilder result;

    private OutputController() {
        result = new StringBuilder();
    }

    public static synchronized OutputController getInstance() {
        if (outputController == null) {
            outputController = new OutputController();
        }

        return outputController;
    }

    public void appendResult(String move) {
        result.append(move);
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
