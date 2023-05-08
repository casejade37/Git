package lectures.resources.lesson2;

public class Car extends CarBase implements Vehicle {
    private float gas;
    private static final float MPG = 10;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.distanceTraveled = 0;
        this.gas = 0;
    }

    @Override
    public float checkFuelLevel() {
        return gas;
    }

    @Override
    public void addFuel(float addedGas) {
        gas += addedGas;
    }

    @Override
    public void drive(float distance) {
        super.drive(distance);
        gas -= distance/MPG;
    }
}
