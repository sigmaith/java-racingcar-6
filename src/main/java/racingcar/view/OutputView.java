package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String MOVE_UNIT = "-";

    public static void printResulttMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(MOVE_UNIT);
        }
        System.out.println(sb);
    }

    public static void printEndMessage(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_MESSAGE);
        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
