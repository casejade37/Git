package PriorityQueue;

public interface PriorityQueue<K,V> {

    int size(); //Get the size of this PQ
    boolean isEmpty(); //Check whether the PQ is empty
    //Insert a new Entry with key and value input
    Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
    //Return the minimum entry from this Priority Queue (highest priority)
    Entry<K,V> min();

    //Remove and return the minimum entry
    Entry<K,V> removeMin();
}
