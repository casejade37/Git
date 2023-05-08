package lectures;

import java.util.Arrays;

public class lesson3 {

    public static void insertionSort(int[] array) {
        int len = array.length;

        for (int i = 1; i < len; i++) {
            int element = array[i];  // element to put in the right place
            int j = i - 1;           // start looking at previous element
            // If element is smaller than previous element, "shift" that element forward
            while (j >= 0 && element < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;
        }

    }
    public static void main(String[] args) {
        int[] toSort = {5, 3, 6, 2, 1};
        insertionSort(toSort);
        System.out.println(Arrays.toString(toSort));

    }
}
