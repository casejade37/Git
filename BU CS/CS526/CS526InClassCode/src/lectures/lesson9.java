package lectures;

import lectures.resources.lesson9.HeapPriorityQueue;
import lectures.resources.lesson9.PriorityQueue;

public class lesson9 {
    public static void main(String[] args) {
        PriorityQueue<Integer, Character> pq = new HeapPriorityQueue<>();

        //Fill priority queue with character + integer index of each character
        for (int i = 0; i < 10; i += 2) {
            pq.insert(i, (char) ('a' + i));
        }
        for (int i = 1; i < 10; i += 2) {
            pq.insert(i, (char) ('g' + i));
        }

        //Test various methods
        System.out.println("Printing full priority queue: " + pq);

        System.out.println("Peeking at min entry: " + pq.min());
        System.out.println("Removing min entry: " + pq.removeMin());

        System.out.println("Printing full priority queue:" + pq);
    }
}
