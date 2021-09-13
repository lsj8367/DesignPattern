package factory;

public abstract class CarFactory {
    public abstract Car createCar(String name);
    public abstract Car returnCar(String name);

    public void numbering() {
        System.out.println("numbering");
    }

    public void washCar() {
        System.out.println("washCar");
    }

    final public void sellCar(String name) {
        numbering();
        createCar(name);
        washCar();
    }
}
