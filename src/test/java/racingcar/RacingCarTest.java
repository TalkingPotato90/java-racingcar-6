package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        List<String> names = Arrays.asList("여섯글자이름", "longName");
        assertThatThrownBy(()->racingCar.validateNameLength(names)).isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 플레이어_이름_별로_이동값_배정_확인(){
        List<String> playersCar = new ArrayList<>(Arrays.asList("감자","고구마","옥수수"));
        List<Boolean> moves = new ArrayList<>(Arrays.asList(false,true,false));
        Map<String,Boolean> moveInfo = new HashMap<>(Map.of("감자",false,"고구마",true,"옥수수",false));

        assertThat(racingCar.createMoveInformation(playersCar, moves)).isEqualTo(moveInfo);
    }

    @Test
    void 최종_우승자_선정_확인(){
        assertThat(racingCar.selectWinner()).isEqualTo("pobi, jun");
    }
}