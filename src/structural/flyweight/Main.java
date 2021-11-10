package structural.flyweight;

import java.awt.Color;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
        Vehicle blueVehicle = VehicleFactory.createVehicle(Color.BLUE);

        System.out.println("둘이 다른 객체일때");

        System.out.println(Objects.isNull(blackVehicle));
        System.out.println(Objects.isNull(blueVehicle));
        System.out.println(blackVehicle == blueVehicle);




        Vehicle redVehicle = VehicleFactory.createVehicle(Color.RED);
        Vehicle anotherRedVehicle = VehicleFactory.createVehicle(Color.RED);

        System.out.println("둘이 같은 객체일 때");

        System.out.println(Objects.isNull(redVehicle));
        System.out.println(Objects.isNull(anotherRedVehicle));
        System.out.println(redVehicle == anotherRedVehicle);
    }

}
