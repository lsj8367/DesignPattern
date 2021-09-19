package structural.decorator;

public class Americano extends Decorator{

    public Americano(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        super.brew();
        System.out.print("Add Water");
    }

}
