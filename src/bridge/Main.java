package bridge;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea"));
        Display d2 = new Display(new StringDisplayImpl("Hello, world"));

        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, universe"));

        d1.display();
        d2.display();
        d3.display();

        d3.multiDisplay(5);
    }
}
