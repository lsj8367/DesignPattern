package credential.factory;

import java.util.HashMap;

public class HyundaiCarFactory extends CarFactory {

    HashMap<String, Car> carMap = new HashMap<>();

    @Override
    public Car createCar(String name) {
        Car car = null;

        if (name.equals("sonata")) {
            car = new Sonata();
        }else if (name.equals("santafe")) {
            car = new Santafe();
        }
        return car;
    }

    @Override
    public Car returnCar(String name) {
        Car car = carMap.get(name);

        if (car == null) {

            if (name.equals("tomas")) {
                car = new Sonata();
            }else if (name.equals("james")) {
                car = new Santafe();
            }

            carMap.put(name, car);
        }

        return car;
    }
}
