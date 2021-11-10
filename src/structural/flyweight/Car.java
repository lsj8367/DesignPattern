package structural.flyweight;

import java.awt.Color;
import java.util.Objects;

public class Car implements Vehicle {
    private Engine engine;
    private Color color;

    public Car(final Engine engine, final Color color) {
        this.engine = engine;
        this.color = color;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(engine, car.engine) && Objects.equals(color,
            car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color);
    }
}
