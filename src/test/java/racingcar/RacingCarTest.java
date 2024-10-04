package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}