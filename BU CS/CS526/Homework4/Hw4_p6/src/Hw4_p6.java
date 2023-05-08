/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
// need to import HashMap, ArrayList, LinkedList classes from java.util package.
// import all packages in case other classes are needed.
import java.util.*;
public class Hw4_p6 {
    /**
     * A helper function to check if the random generated number in the main function is in the array,
     * which help generate distinct random numbers in the main function.
     * @param array the array to be looped
     * @param number the number to be checked whether it is contained in the array
     * @return true if the number is in the array; false if not.
     */
    public static boolean contains(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * main function to construct and compare time of insertion and search among HashMap, ArrayList,
     * LinkedList.
     * Related instance variables are generated within this function and the results will be printed
     * to the terminal console.
     */
    public static void main(String[] args) {
//        create constants of test iterations, length of the array to store integers,
//        range for insertion, range for search.
        int testIteration = 10;
        final int CAPACITY = 100000;
        final int insertRange = 1000000;
        final int searchRange = 2000000;
//        initiate time variables for all 3 data structures for insertion
        long mapInsertTime = 0;
        long arrayListInsertTime = 0;
        long linkedListInsertTime = 0;
//        initiate time variables for all 3 data structures for search
        long mapSearchTime = 0;
        long arrayListSearchTime = 0;
        long linkedListSearchTime = 0;
//        outer for loop to perform tests for 10 times (testIteration constant can be changed)
        for (int j = 0; j < testIteration; j++) {
            int[] insertKeys = new int[CAPACITY];
            int[] searchKeys = new int[CAPACITY];

            // generate distinct random keys for insertion
            Random r = new Random(System.currentTimeMillis());
            for (int i = 0; i < CAPACITY; i++) {
                int num = r.nextInt(insertRange) + 1;
                while (contains(insertKeys, num)) {
//                    if num is contained in insertKeys array, find next random number to avoid duplicates
                    num = r.nextInt(insertRange) + 1;
                }
//                num is guaranteed to be distinct, thus being added to the insertKeys array.
                insertKeys[i] = num;
            }

            // create empty data structures
            Map<Integer, Integer> myMap = new HashMap<>();
            List<Integer> myArrayList = new ArrayList<>();
            List<Integer> myLinkedList = new LinkedList<>();

            // measure insertion time for map
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                // Insert keys one at a time but measure only the total time (not individual insert time)
                myMap.put(insertKeys[i], i);
            }
            long endTime = System.currentTimeMillis();
//                keep incrementing insertTime until tests complete to get the total time for all tests.
            mapInsertTime += endTime - startTime;

            // measure insertion time for array list (same logic as map)
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                myArrayList.add(insertKeys[i]);
            }
            endTime = System.currentTimeMillis();
            arrayListInsertTime += endTime - startTime;

            // measure insertion time for linked list (same logic as map)
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                myLinkedList.add(insertKeys[i]);
            }
            endTime = System.currentTimeMillis();
            linkedListInsertTime += endTime - startTime;

            // generate distinct random keys for search (same logic as distinct random keys for insertion)
            r.setSeed(System.currentTimeMillis());
            for (int i = 0; i < CAPACITY; i++) {
                int num = r.nextInt(searchRange) + 1;
                while (contains(searchKeys, num)) {
                    num = r.nextInt(searchRange) + 1;
                }
                searchKeys[i] = num;
            }

            // measure search time for map (same logic as map insertion)
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                myMap.containsKey(searchKeys[i]);
            }
            endTime = System.currentTimeMillis();
            mapSearchTime += endTime - startTime;


            // measure search time for array list (same logic as map)
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                myArrayList.contains(searchKeys[i]);
            }
            endTime = System.currentTimeMillis();
            arrayListSearchTime += endTime - startTime;


            // measure search time for linked list (same logic as map)
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CAPACITY; i++) {
                myLinkedList.contains(searchKeys[i]);
            }
            endTime = System.currentTimeMillis();
            linkedListSearchTime += endTime - startTime;
        }


        // calculate average times by dividing test times
        long mapAvgInsertTime = mapInsertTime / testIteration;
        long listAvgInsertTime = arrayListInsertTime / testIteration;
        long linkedListAvgInsertTime = linkedListInsertTime / testIteration;

        long mapAvgSearchTime = mapSearchTime / testIteration;
        long listAvgSearchTime = arrayListSearchTime / testIteration;
        long linkedListAvgSearchTime = linkedListSearchTime / testIteration;

        // print output
        System.out.println("Number of keys = " + CAPACITY);
        System.out.println();
        System.out.println("HashMap average total insert time = " + mapAvgInsertTime);
        System.out.println("ArrayList average total insert time = " + listAvgInsertTime);
        System.out.println("LinkedList average total insert time = " + linkedListAvgInsertTime);
        System.out.println();
        System.out.println("HashMap average total search time = " + mapAvgSearchTime);
        System.out.println("ArrayList average total search time = " + listAvgSearchTime);
        System.out.println("LinkedList average total search time = " + linkedListAvgSearchTime);
    }
}
