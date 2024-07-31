package racingcar.util;

import static java.util.Arrays.stream;

public class Validator {
    private static final String DELIMITER = ",";
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public static String[] validateCarNames(String carNames) {
        String[] carNameArray = carNames.split(DELIMITER);
        if (!areCarNamesValid(carNameArray)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분하여 비어 있지 않고 1자에서 5자 사이여야 합니다.");
        }
        return carNameArray;
    }

    public static int validateAttemptCount(String attemptCount) {
        if (!attemptCount.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
        return Integer.parseInt(attemptCount);
    }

    private static boolean areCarNamesValid(String[] carNameArray) {
        return carNameArray.length > 0 &&
                stream(carNameArray)
                        .allMatch(carName -> carName.length() >= 1 && carName.length() <= 5);
    }
}
