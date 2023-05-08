package lectures;

import java.util.Arrays;

public class lesson5 {

    public static int factorial(int n) {
        System.out.printf("Running factorial(%d)\n", n);
        if (n == 0) {
            return 1;
        }
        int recursiveResult = factorial(n - 1);
        System.out.printf("Got result from running factorial(%d) inside of factorial(%d)\n", n - 1, n);
        return n * recursiveResult;
    }

    public static boolean binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length-1);
    }

    public static boolean binarySearchHelper(int[] array, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        // Check the middle element
        int midpoint = (low + high) / 2;    // This rounds down since result is casted down to int
        // We found it => we are done!
        if (array[midpoint] == target) {
            return true;
        }
        // The target is bigger than middle element => check the larger half
        else if (array[midpoint] < target) {
            return binarySearchHelper(array, target, midpoint + 1, high);
        }
        // The target is smaller than middle element =? check the smaller half
        else {
            return binarySearchHelper(array, target, low, midpoint -1);
        }
        // Why do we have to do midpoint +/- 1?

    }

    public static void reverseArray(int[] data) {
        reverseArrayHelper(data, 0, data.length-1);
    }


    public static void reverseArrayHelper(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
        reverseArrayHelper(data, low + 1, high - 1);
    }

    public static void towerOfHanoi(int numberOfDisks) {
        towerOfHanoiHelper(numberOfDisks, 'A', 'B', 'C');
        System.out.println("Done!");

    }

    public static boolean binarySearchIterative(int[] array, int target) {
        // Keep track of state
        int low = 0, high = array.length - 1;

        // "Base case" is now just when we need to end
        while (low <= high) {
            // Check the middle element
            int midpoint = (low + high) / 2;    // This rounds down since result is casted down to int
            // We found it => we are done!
            if (array[midpoint] == target) {
                return true;
            }
            // The target is bigger than middle element => check the larger half
            else if (array[midpoint] < target) {
                low = midpoint + 1;  // instead of recursion, update variables
            }
            // The target is smaller than middle element =? check the smaller half
            else {
                high = midpoint - 1;
            }
        }
        return false;

    }

    public static void towerOfHanoiHelper(int numberOfDisks, char startingPeg, char endingPeg, char helperPeg) {
        if (numberOfDisks == 0) {
            return;
        }
        // Move n-1 disks to helper peg
        towerOfHanoiHelper(numberOfDisks - 1, startingPeg, helperPeg, endingPeg);
        // Move last disk to ending peg
        System.out.printf("Move disk size %d from %s to %s%n", numberOfDisks, startingPeg, endingPeg);
        // Move n-1 disks from helper peg to ending peg
        towerOfHanoiHelper(numberOfDisks - 1, helperPeg, endingPeg, startingPeg);


    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
        int[] array = {1,2,3,4,5};
        System.out.println(binarySearch(array, 2));
        System.out.println(binarySearch(array, 7));

        reverseArray(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1,2,3,4,5};

        System.out.println(binarySearchIterative(array, 2));
        System.out.println(binarySearchIterative(array, 7));

        towerOfHanoi(3);

    }
}
