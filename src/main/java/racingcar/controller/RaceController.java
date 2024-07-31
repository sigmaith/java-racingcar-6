package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        OutputView.printResulttMessage();
        Random random = new Random();
        for (int i = 0; i < attemptCount; i++) {
            moveCars(random);
            OutputView.printCars(cars);
            System.out.println();
        }
//        List<Car> winners = Car.findWinners(cars);
//        OutputView.printEndMessage(winners);

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

    private void moveCars(Random random) {
        for (Car car : cars) {
            car.moveForwardOrNot(random);
        }
    }

}
