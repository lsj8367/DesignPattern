package structural.flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private static Map<Color, Vehicle> vehicleMap = new HashMap<>();

    public static Vehicle createVehicle(Color color) {
        Vehicle newVehicle = vehicleMap.computeIfAbsent(color, VehicleFactory::of);
        return newVehicle;
    }

    private static Vehicle of(Color newColor) {
        Engine newEngine = new Engine();
        return new Car(newEngine, newColor);
    }
}
