package lectures;

import lectures.resources.lesson2.Car;
import lectures.resources.lesson2.ElectricCar;
import lectures.resources.lesson2.GenericHolder;
import lectures.resources.lesson2.Vehicle;

import java.io.FileNotFoundException;

public class lesson2 {


    public static void testDriveCar(Vehicle car) {
        car.addFuel(10);
        car.drive(20);
        System.out.println("License Plate: " + car.getLicensePlate());
        System.out.println("Fuel Level: " + car.checkFuelLevel());
        System.out.println("Mileage: " + car.getDistanceTraveled());
        car.honk();
    }

    public static void exceptionExample() {
        for (int i : new int[]{5, 10, 200}) {
            try {
                validateNumber(i);
                System.out.printf("%d is valid!\n", i);
            } catch (IllegalArgumentException e1) {
                System.out.printf("%d is too small\n", i);
                // In production systems, we usually don't like to swallow errors
            } catch (FileNotFoundException e) {
                System.out.printf("%d is too large\n", i);
            }
        }
    }

    public static void validateNumber(int number) throws IllegalArgumentException, FileNotFoundException {
        if (number < 10) {
            throw new IllegalArgumentException();
        }
        if (number > 100) {
            throw new FileNotFoundException();
        }
    }

    public static void main(String[] args) {
        // Car hierarchy
        Vehicle car = new Car("Car1");
        Vehicle car2 = new ElectricCar("Car2");

//        testDriveCar(car);
//        testDriveCar(car2);

        exceptionExample();

        // Generics example
        GenericHolder<Integer> g = new GenericHolder();
        g.setGeneric(5); // Must be an integer now
        g.setObject("ANY OBJECT");
    }



}
