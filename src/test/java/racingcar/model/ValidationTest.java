package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @Test
    void 이름이_5자_초과면_예외(){
        List<String> names = Arrays.asList("여섯글자이름", "longName");
        assertThatThrownBy(()->validation.validateNameLength(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가_숫자가_아니면_예외(){
        assertThatThrownBy(()->validation.validateTryCounts("-6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가_10을_넘으면_예외(){
        assertThatThrownBy(()->validation.validateTryCounts("11")).isInstanceOf(IllegalArgumentException.class);
    }
}