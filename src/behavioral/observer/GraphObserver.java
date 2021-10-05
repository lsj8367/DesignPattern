package behavioral.observer;

public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("GraphObserver");
        int number = numberGenerator.getNumber();

        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }

        System.out.println();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
