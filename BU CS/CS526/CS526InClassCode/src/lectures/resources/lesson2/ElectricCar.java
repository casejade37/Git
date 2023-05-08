package lectures.resources.lesson2;

public class ElectricCar extends CarBase implements Vehicle {
    private float batteryLevel;
    private static final int MPG = 5;

    public ElectricCar() {
        // Example of polymorphism
        this("Missing License Plate");
    }
    public ElectricCar(String licensePlate) {
        this.licensePlate = licensePlate;
        this.batteryLevel = 100;
    }
    @Override
    public void addFuel(float chargeAmount) {
        batteryLevel += chargeAmount;
    }

    @Override
    public float checkFuelLevel() {
        return batteryLevel;
    }

    @Override
    public void drive(float distance) {
        super.drive(distance);
        batteryLevel -= distance/MPG;
    }
}
