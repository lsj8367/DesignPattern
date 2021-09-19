package structural.decorator;

public class Latte extends Decorator {

    public Latte(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        super.brew();
        System.out.print("Add Milk");
    }

}
