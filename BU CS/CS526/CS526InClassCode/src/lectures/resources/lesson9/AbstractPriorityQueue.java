package lectures.resources.lesson9;

import java.util.Comparator;

//Abstract priority queue, with Priority Queue entry defined
//Constructors, and comparators also defined
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    //Entry for a priority queue implementation of the Entry interface
    //Just get and set methods
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;

        public PQEntry(K key, V value){
            k = key;
            v = value;
        }

        public K getKey(){return k;}
        public V getValue(){return v;}

        protected void setKey (K key) {k = key;}
        protected void setValue(V value){v = value;}

        public String toString()
        {
            String s = "(" + k.toString() + "," + v.toString() + ")";
            return s;
        }
    }


    private Comparator<K> comp;
    protected AbstractPriorityQueue(Comparator<K> c) {comp = c;}
    protected AbstractPriorityQueue(){this(new DefaultComparator<>());}

    protected int compare(Entry<K,V> a, Entry<K,V> b)
    {
        return comp.compare(a.getKey(),b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try{
            return (comp.compare(key,key)==0);
        }
        catch(ClassCastException e)
        {
            throw new IllegalArgumentException("Incompatible key");
        }
    }


    public boolean isEmpty(){return size()==0;}

}
