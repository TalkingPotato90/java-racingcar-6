package racingcar;

public class RacingCar {
    public void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 각 이름의 길이는 5자 이내로 가능합니다.");
        }
    }

    public void validateTryCounts(String inputCounts) {
        if(!inputCounts.matches("^[0-9]*$")){
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 숫자만 입력가능합니다.");
        }
    }
}
