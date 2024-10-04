package racingcar;

public class RacingCar {
    public void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 각 이름의 길이는 5자 이내로 가능합니다.");
        }
    }
}
