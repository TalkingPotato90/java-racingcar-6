package racingcar.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {
    public void print() {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            br.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            br.flush();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
