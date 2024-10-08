package racingcar.util;

public enum Guide {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자"),
    JOIN(", "),
    SPLIT(","),
    MOVE("-"),
    COLON(" : "),
    ONLY_DIGIT("^[0-9]*$"),
    NAME_LENGTH_ERROR("[ERROR] 각 이름의 길이는 5자 이내로 가능합니다."),
    TRY_COUNT_FORMAT_ERROR("[ERROR] 시도할 횟수는 숫자만 입력가능합니다."),
    TRY_COUNT_MAX_VALUE_ERROR("[ERROR] 시도할 횟수는 10회 이하로만 가능합니다.");

    private String message;

    private Guide(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
