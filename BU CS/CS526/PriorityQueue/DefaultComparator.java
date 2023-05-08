package PriorityQueue;

import java.util.Comparator;
//A default comparator if a comparator isn't specified by the user
//Uses the object's compareTo method to perform comparisons
public class DefaultComparator<E> implements Comparator<E> {

    public int compare(E a, E b) throws ClassCastException{
        return  ((Comparable<E>) a).compareTo(b);
    }
}
