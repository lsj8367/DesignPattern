package structural.decorator;

public class Decorator extends Coffee {

    Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void brew() {
        coffee.brew();
    }

}
