package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        InputView inputView = new InputView();
        String message = inputView.getUserInput();

        outputView.print("시도할 회수는 몇회인가요?");
    }
}
