package racingcar.util;

public enum Value {
    RANDOM_MIN(0),
    RANDOM_MAX(9),
    DEFAULT_POSITION(-1),
    MOVE_BASE(4),
    NAME_LENGTH_MAX(5),
    TRY_COUNT_MAX(10);

    private int number;

    Value(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
