package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱카 테스트")
class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void 이름이_5자_초과(){
        assertThatThrownBy(()->racingCar.validateNameLength("여섯글자이름")).isInstanceOf(IllegalArgumentException.class);
    }
}