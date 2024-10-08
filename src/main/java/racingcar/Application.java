package racingcar;

import racingcar.model.RacingCar;
import racingcar.model.Validation;
import racingcar.util.Guide;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.print(Guide.START.getMessage());

        InputView inputView = new InputView();
        String carNames = inputView.getUserInput();

        RacingCar racingCar = new RacingCar();
        Validation validation = new Validation();
        List<String> playerCars = racingCar.createPlayersCar(carNames);
        validation.validateNameLength(playerCars);

        outputView.print(Guide.TRY_COUNT.getMessage());

        String count = inputView.getUserInput();
        validation.validateTryCounts(count);

        outputView.print(Guide.RESULT.getMessage());

        for (int i = 0; i < Integer.parseInt(count); i++) {
            List<Integer> randomNumbers = racingCar.createRandomNumber(playerCars.size());
            List<Boolean> moves = racingCar.createMove(randomNumbers);
            Map<String, Boolean> moveInformation = racingCar.createMoveInformation(playerCars, moves);


            racingCar.printResult(moveInformation, playerCars);
        }

        String winner = racingCar.selectWinner(playerCars);

        outputView.print(Guide.WINNER.getMessage() + Guide.COLON.getMessage() + winner);

    }
}
