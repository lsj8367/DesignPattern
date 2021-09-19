package structural.decorator;

public class Main {

    public static void main(String[] args) {
        Coffee columbia = new Columbia();
        columbia.brew();

        System.out.println();
        Coffee ethiopia = new Ethiopia();
        ethiopia.brew();

        System.out.println();
        Americano americano = new Americano(columbia);
        americano.brew();

        System.out.println();
        Latte latte = new Latte(new Americano(columbia));
        latte.brew();
    }
}
