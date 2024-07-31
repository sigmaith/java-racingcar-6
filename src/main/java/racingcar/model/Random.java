package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Random {
    private int number;

    public int generateNumber() {
        number = pickNumberInRange(0, 9);
        return number;
    }
}
