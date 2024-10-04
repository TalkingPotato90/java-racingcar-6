package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱카 테스트")
class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void 이름이_5자_초과면_예외(){
        assertThatThrownBy(()->racingCar.validateNameLength("여섯글자이름")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가_숫자가_아니면_예외(){
        assertThatThrownBy(()->racingCar.validateTryCounts("-6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가_10을_넘으면_예외(){
        assertThatThrownBy(()->racingCar.validateTryCounts("11")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정된_개수만큼_무작위_숫자_생성(){
        assertThat(racingCar.createRandomNumber(5)).hasSize(5);
    }

    @Test
    void 입력받은_사용자_이름_쉼표로_구분하기(){
        assertThat(racingCar.createPlayersCar("감,자,동차")).hasSize(3);
    }

    @Test
    void 자동차_수와_무작위_수의_개수_일치(){
        assertThat(racingCar.createPlayersCar("감자,의자,동차,넷"))
                .hasSize(racingCar.createRandomNumber(4).size());
    }

    @Test
    void 무작위_숫자에_따라_이동_여부_확인(){
        List<Integer> randoms = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Boolean> moves = new ArrayList<>(Arrays.asList(false,false,false,true,true));
        assertThat(racingCar.createMove(randoms)).containsExactlyElementsOf(moves);
    }
}