package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class RaceController {
    private List<Car> cars;
    private int carCount;
    private int attemptCount;

    public void operate() {
        InputView inputView = new InputView();
        setCarCount(inputView.getCarNames().length);
        setAttemptCount(inputView.getAttemptCount());

        createCars(inputView.getCarNames());



    }

    private void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    private void createCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
