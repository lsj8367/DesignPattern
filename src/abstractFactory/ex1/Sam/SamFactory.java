package abstractFactory.ex1.Sam;

import abstractFactory.ex1.facto.BikeFactory;
import abstractFactory.ex1.facto.Body;
import abstractFactory.ex1.facto.Wheel;

public class SamFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new SamBody();
    }

    @Override
    public Wheel createWheel() {
        return new SamWheel();
    }
}
