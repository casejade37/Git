package PriorityQueue;

public class PQTester {

    public static void main(String [] args) {

        //Create a new priority queue with integer keys and character values
        PriorityQueue<Integer, Character> pq = new HeapPriorityQueue<Integer, Character>();

        //Fill priority queue with character + integer index of each character
        for (int i = 0; i < 10; i++)
        {
            pq.insert(i, (char) ('a' + i));
        }

        //Test various methods
        System.out.println("Printing full priority queue:" + pq.toString());

        System.out.println("Peeking at min entry: " + pq.min());
        System.out.println("Removing min entry: " + pq.removeMin());

        System.out.println("Printing full priority queue:" + pq.toString());
    }
}
