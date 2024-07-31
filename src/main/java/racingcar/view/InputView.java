package racingcar.view;

import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    public static String[] getCarNames() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        String carNames = readLine();
        return Validator.validateCarNames(carNames);
    }

    public static int getAttemptCount() {
        System.out.println(ASK_ATTEMPT_COUNT);
        String attemptCount = readLine();
        return Validator.validateAttemptCount(attemptCount);
    }
}
