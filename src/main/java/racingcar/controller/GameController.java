package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.Validation;
import racingcar.util.Guide;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {
    private RacingCar racingCar;
    private OutputView outputView;
    private InputView inputView;
    private Validation validation;
    private WinnerController winnerController;
    private List<String> playerCars;

    public GameController() {
        this.racingCar = new RacingCar();
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.validation = new Validation();
        this.winnerController = new WinnerController();
    }

    public void playGame() {
        confirmCarNames();
        repeatGame(confirmTryCounts());
        finishGame();
    }

    private void confirmCarNames() {
        outputView.print(Guide.START.getMessage());
        String carNames = inputView.getUserInput();
        playerCars = racingCar.createPlayersCar(carNames);
        validation.validateNameLength(playerCars);
    }

    private String confirmTryCounts() {
        outputView.print(Guide.TRY_COUNT.getMessage());
        String count = inputView.getUserInput();
        validation.validateTryCounts(count);

        return count;
    }

    private void repeatGame(String count) {
        List<Integer> randomNumbers;
        List<Boolean> moves;
        Map<String, Boolean> moveInformation;

        for (int i = 0; i < Integer.parseInt(count); i++) {
            randomNumbers = racingCar.createRandomNumber(playerCars.size());
            moves = racingCar.createMove(randomNumbers);
            moveInformation = racingCar.createMoveInformation(playerCars, moves);

            winnerController.printResult(moveInformation, playerCars);
        }
    }

    private void finishGame() {
        outputView.print(Guide.RESULT.getMessage());
        String winner = winnerController.selectWinner(playerCars);
        outputView.print(Guide.WINNER.getMessage() + Guide.COLON.getMessage() + winner);
    }
}
