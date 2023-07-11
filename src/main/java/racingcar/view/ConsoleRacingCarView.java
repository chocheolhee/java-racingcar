package racingcar.view;

import racingcar.dto.Results;
import racingcar.dto.Winner;
import racingcar.dto.Winners;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleRacingCarView implements RacingCarView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String PLAY_RESULT = "\n실행 결과\n";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String JOIN_DELIMITER = " ,";
    private static final String SCORE_SYMBOL = "-";
    private static final String RESULT_DELIMITER = " : ";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printCarNamesPrompt() {
        System.out.println(CAR_NAMES_PROMPT);
    }

    @Override
    public void printCountPrompt() {
        System.out.println(COUNT_PROMPT);
    }

    @Override
    public void printResults(List<Results> totalResult) {
        System.out.println(PLAY_RESULT);
        for (Results results : totalResult) {
            printResult(results);
        }
    }

    @Override
    public void printResult(Results results) {
        String output = results.get().stream()
                .map(car -> car.getName() + RESULT_DELIMITER + SCORE_SYMBOL.repeat(car.getScore()))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output + "\n");
    }

    @Override
    public void printWinners(Winners winners) {
        String output = winners.get().stream()
                .map(Winner::getName)
                .collect(Collectors.joining(JOIN_DELIMITER));

        System.out.println(output + WINNER_MESSAGE);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}