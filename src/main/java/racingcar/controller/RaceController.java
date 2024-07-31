package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private List<Car> cars;
    private int attemptCount;

    public void operate() {
        InputView inputView = new InputView();
        setAttemptCount(inputView.getAttemptCount());

        createCars(inputView.getCarNames());
        OutputView.printResulttMessage();
        Random random = new Random();
        for (int i = 0; i < attemptCount; i++) {
            moveCars(random);
            OutputView.printCars(cars);
            System.out.println();
        }

        List<Car> winners = findWinners(cars);
        OutputView.printEndMessage(winners);
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    private void createCars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void moveCars(Random random) {
        for (Car car : cars) {
            car.moveForwardOrNot(random);
        }
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
