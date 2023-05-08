/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
import java.util.Arrays;
import java.util.Random;
public class Hw5_P7 {
 public static void main(String[] args) {
//            initialize test sizes from 10000 to 100000
            int[] sizes = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
            Random r = new Random();
            for (int n : sizes) {
//              loop tests for 10 times
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
//                    generate random numbers for every test
                    arr[i] = r.nextInt(1000000) + 1;
                }
                int[] arrCopy = Arrays.copyOf(arr, n);
//              use nanoTime for greater accuracy
                long startTime = System.nanoTime();
                insertionSort(arrCopy);
                long endTime = System.nanoTime();
//                convert results back to milliseconds
                long elapsedTime = (endTime - startTime) / 1000000;
                System.out.println("Insertion sort with n = " + n + " took " + elapsedTime + " milliseconds");

                arrCopy = Arrays.copyOf(arr, n);
                startTime = System.nanoTime();
                mergeSort(arrCopy);
                endTime = System.nanoTime();
                elapsedTime = (endTime - startTime) / 1000000;
                System.out.println("Merge sort with n = " + n + " took " + elapsedTime + " milliseconds");

                arrCopy = Arrays.copyOf(arr, n);
                startTime = System.nanoTime();
                quickSort(arrCopy, 0, n - 1);
                endTime = System.nanoTime();
                elapsedTime = (endTime - startTime) / 1000000;
                System.out.println("Quick sort with n = " + n + " took " + elapsedTime + " milliseconds");

                arrCopy = Arrays.copyOf(arr, n);
                startTime = System.nanoTime();
                heapSort(arrCopy);
                endTime = System.nanoTime();
                elapsedTime = (endTime - startTime) / 1000000;
                System.out.println("Heap sort with n = " + n + " took " + elapsedTime + " milliseconds");
            }
        }

    /**
     * The insertionSort method takes in an array, and sorts it in place using insertion sort.
     * @param arr: the array to be sorted.
     *           return: void => the array will be rearranged in place.
     */
        public static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

    /**
     * The mergeSort method use divide and conquer strategy to sort an array.
     * @param arr: the array to be sorted.
     *           return: void => although merge sort is not in place, a helper function merge is used to
     *           add sorted elements into the original array.
     */
        public static void mergeSort(int[] arr) {
            if (arr.length > 1) {
                int mid = arr.length / 2;
//                divide array in half into two subarrays
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);
//                conquer with recursion
                mergeSort(left);
                mergeSort(right);
//              merge sorted halves back into original
                merge(left, right, arr);
            }
        }

    /**
     * merge is a helper function used in merge sort for merging sorted subarrays into a complete array.
     * @param left: subarray in the left half part.
     * @param right: subarray in the right half part.
     * @param array: original array.
     *             return: void => the original array is inserted with sorted elements from subarrays.
     */
        private static void merge(int[] left, int[] right, int[] array){
                int i = 0, j = 0;
                while (i + j < array.length) {
//                    if right pointer j reaches the end; or the value at left pointer i is less than the value at j
                    if (j == right.length || (i < left.length && left[i] < right[j])) {
//                        copy ith element of left and increment i
                        array[i + j] = left[i++];
                    } else {
//                        copy jth element of right and increment j
                        array[i + j] = right[j++];
                    }
                }
            }

    /**
     * The quickSort method recursively calls itself on the left and right subarrays after partitioning the current subarray.
     * @param arr: the array to be sorted.
     * @param left: the leftmost index of the subarray to be sorted.
     * @param right: the rightmost index of the subarray to be sorted.
     *             return void => the array is sorted in place.
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
//            use helper function partition to obtain a pivot index
            int pivotIndex = partition(arr, left, right);
//            recursively sort two parts divided by pivot index
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * The partition helper method is used to return the pivot index for quick sort.
     * @param arr: the array to be partitioned.
     * @param left: the leftmost index of the subarray to be partitioned.
     * @param right: the rightmost index of the subarray to be partitioned.
     * @return: the index of the pivot.
     */
    private static int partition(int[] arr, int left, int right) {
//         selects the rightmost element as the pivot
        int pivotValue = arr[right];
//        partitions the subarray into two parts: elements smaller than the pivot on the left side,
//        and elements greater than or equal to the pivot on the right side.
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    /**
     * A helper function to swap two elements (i.e. i & j).
     * @param arr: the array containing the two elements.
     * @param i: the element to be swapped with j.
     * @param j: the element to be swapped with i.
     *         return: void => the array will be rearranged in place with swapped i and j.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * The heapSort method takes an array to be sorted and rearranges the elements into a max heap by calling the heapify method.
     * It then extracts the elements from the heap one by one and puts them in their final positions in the array.
     * @param arr: the array to be sorted.
     * return: void => the original array will be rearranged in place.
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * The heapify method builds a heap to be used in heap sort.
     * @param arr: the array to be heapified
     * @param n: the size of the heap,
     * @param i: an index of the root of the subtree to be heapified.
     *         return void => recursively heapifies the subtree rooted at the largest index
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

//      checks if the left or right child of the root is larger than the root and sets the largest index accordingly.
//      If the largest index is not the root, it swaps the root with the element at largest index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}