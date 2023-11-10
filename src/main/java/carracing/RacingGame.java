package carracing;

import java.util.ArrayList;
import java.util.List;

import static carracing.GameWinner.carRaceTopPosition;
import static carracing.ui.ResultView.carRacingWinnersView;
import static carracing.ui.ResultView.printResultRaceGameProcess;
import static carracing.util.InputValueValidate.splitCommaInputCarName;
import static carracing.util.InputValueValidate.verifyExceedFiveCarName;

public class RacingGame {

    private final List<Car> carList;
    private final int trialCount;
    private final RandomNumberGenerator random = new RandomNumberGenerator();

    public RacingGame(String carName, int trialCount) {
        this.carList = cars(carName);
        this.trialCount = negativeNumberCheck(trialCount);
    }

    public void gameStart() {
        for (int i = 0; i < trialCount; i++) {
            racingGameProcess();
            System.out.println();
        }
        carRacingWinnersView(carList);
    }

    private List<Car> cars(String carName) {
        return makeCarList(carName);
    }

    private void racingGameProcess() {
        for (Car car : carList) {
            car.move(random.getRandomNumber());
            printResultRaceGameProcess(car);
            carRaceTopPosition(car);
        }
    }

    private static List<Car> makeCarList(String carName) {
        String[] names = splitCommaInputCarName(carName);
        checkExceedFiveCarName(names);

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    private static void checkExceedFiveCarName(String[] names) {
        for (String name : names) {
            verifyExceedFiveCarName(name);
        }
    }

    private static int negativeNumberCheck(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

}
