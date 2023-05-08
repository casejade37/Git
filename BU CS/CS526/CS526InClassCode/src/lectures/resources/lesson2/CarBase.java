package lectures.resources.lesson2;

public abstract class CarBase implements Vehicle {
    protected String licensePlate;
    protected float distanceTraveled;

    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public void drive(float distance) {
        distanceTraveled += distance;
    }

    @Override
    public void honk() {
        System.out.println("HONK!");
    }


}
