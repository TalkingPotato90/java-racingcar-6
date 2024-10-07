package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        InputView inputView = new InputView();
        String message = inputView.getUserInput();

        RacingCar racingCar = new RacingCar();
        List<String> playerCars = racingCar.createPlayersCar(message);
        racingCar.validateNameLength(playerCars);

        outputView.print("시도할 회수는 몇회인가요?");

        String count = inputView.getTryCounts();
        racingCar.validateTryCounts(count);

        outputView.print("실행 결과");

        for (int i = 0; i < Integer.parseInt(count); i++) {
            List<Integer> randomNumbers = racingCar.createRandomNumber(playerCars.size());
            List<Boolean> moves = racingCar.createMove(randomNumbers);
            Map<String, Boolean> moveInformation = racingCar.createMoveInformation(playerCars, moves);


            racingCar.printResult(moveInformation, playerCars);
        }

        String winner = racingCar.selectWinner(playerCars);

        outputView.print("최종 우승자 : ");

    }
}
