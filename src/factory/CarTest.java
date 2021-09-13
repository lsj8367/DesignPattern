package factory;

public class CarTest {

    public static void main(String[] args) {
        CarFactory carFactory = new HyundaiCarFactory();
        Car car = carFactory.createCar("sonata");
        System.out.println(car);

        Car returnCar1 = carFactory.returnCar("tomas");
        Car returnCar2 = carFactory.returnCar("tomas");

        System.out.println(returnCar1 == returnCar2);
    }

}
