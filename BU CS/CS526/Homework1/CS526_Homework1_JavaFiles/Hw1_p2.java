/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hw1_p2 {
	/**
	 * findByMake method is used to find if there are cars with the same make are in the cars array.
	 * Input:
	 * @param cars: an object array
	 * @param make: a string indicating the make to be found.
	 * Output:
	 * void returns nothing. Only print relevant messages on the screen.
	 */
	public static void findByMake(Car[] cars, String make) {
		// implement this method
//		initialize a boolean param to false as a flag
		boolean found = false;
//		use a for loop to check the value
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getMake().equals(make)) {
				System.out.println(cars[i]);
//				update the flag to true if at least one is found
				found = true;
			}
		}
//		if not found, print a message
		if (found == false) {
			System.out.print("there is no car with the given make.");
		}
	}

	/**
	 * olderThan method is used to find if there are cars in the cars array that are manufactured earlier than the target year.
	 * Input:
	 * @param cars: an object array
	 * @param year: an integer indicating the make to be found.
	 * Output:
	 * void returns nothing. Only print relevant messages on the screen.
	 */
	public static void olderThan(Car[] cars, int year) {
		// implement this method
//		initialize a boolean param to false as a flag
		boolean found = false;
//		use a for loop to check if year of the car is less than the target year.
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getYear() < year) {
				System.out.println(cars[i]);
//				update the flag to true if at least one is found
				found = true;
			}
		}
//		if not found, print a message
		if (found == false) {
			System.out.print("there is no car older than the given year.");
		}
	}
	
	public static void main(String[] args) throws IOException {

		// complete this part
		// create an array of Car objects, cars, of size 10
		// read input file and store 10 car Objects in the array
		Car[] cars = new Car[10];
		Scanner fileInput = new Scanner (new File("car_input.txt"));
//		set an index to track element position in array cars
		int index = 0;
			while (fileInput.hasNextLine()) {
//				read the file, one line at a time
				String[] carInfo = fileInput.nextLine().split(", ");
//				create a Car object
				Car car = new Car();
//				setter to set the value to car property
				car.setMake(carInfo[0]);
				car.setPrice(Integer.parseInt(carInfo[1]));
				car.setYear(Integer.parseInt(carInfo[2]));
//				add the Car object to the array cars
				cars[index] = car;
				index++;
			}
		fileInput.close();

		System.out.println("\nAll cars:");
		for (int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}

		String make = "Honda";
		int year = 2017;

		System.out.println("\nAll cars made by " + make);
		findByMake(cars, make);
		System.out.println("\nAll cars made before " + year);
		olderThan(cars, year);
	}

}
