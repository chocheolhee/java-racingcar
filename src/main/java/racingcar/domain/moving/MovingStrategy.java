package racingcar.domain.moving;

@FunctionalInterface
public interface MovingStrategy {
    Moving go();
}