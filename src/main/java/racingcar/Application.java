package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        outputView.print();

        InputView inputView = new InputView();
        String message = inputView.getUserInput();

        System.out.println(message);
    }
}
