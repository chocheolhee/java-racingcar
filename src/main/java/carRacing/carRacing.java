package carRacing;

public class carRacing {
    public static void main(String[] args) {

        InputScanner inputScanner = new InputScanner();
        inputScanner.inputCarCount();
        inputScanner.inputTrialCount();

        RacingGame game = new RacingGame(inputScanner.carCount(),inputScanner.trialCount());
        game.gameStart();
    }

}