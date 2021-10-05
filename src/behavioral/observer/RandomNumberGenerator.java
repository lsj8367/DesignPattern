package behavioral.observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {

    private final Random random = new Random();
    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 50; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
