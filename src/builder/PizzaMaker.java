package builder;

import builder.NewYorkPizza.Size;
import builder.Pizza.Topping;

public class PizzaMaker {
    public static void main(String[] args) {
        Pizza newYorkPizza = new NewYorkPizza.Builder(Size.SMALL)
                .addTopping(Topping.ONION)
                .addTopping(Topping.HAM).build();

        Pizza calzone = new Calzone.Builder()
                .addTopping(Topping.MUSHROOM)
                .addTopping(Topping.SAUSAGE)
                .sauceInside()
                .build();

        System.out.println(newYorkPizza);
        System.out.println(calzone);
    }
}
