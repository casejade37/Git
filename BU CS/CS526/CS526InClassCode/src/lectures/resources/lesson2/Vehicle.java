package lectures.resources.lesson2;

public interface Vehicle {
    void drive(float distance);
    void honk();
    String getLicensePlate();
    void addFuel(float fuelAmount);
    float checkFuelLevel();
    float getDistanceTraveled();
}
