package lectures.resources.lesson7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
    private E [] array;
    private int size;
    private static final int DEFAULT_CAPACITY=10;

    public MyArrayList() {
        size = 0;
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    protected void resize() {
        // Double the size of the array
        E [] tmp = (E[]) new Object[array.length*2];

        // Copy the values over
        for(int i = 0; i < this.size;i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void add(E data) {
        add(size, data);
    }
    public void add(int i, E data) {
        if(size == array.length) {
            resize();
        }
        checkIndex(i,size+1);

        for(int k = size - 1; k >= i; i--) {
            array[k+1] = array[k];
        }

        array[i] = data;
        size++;
    }

    protected void checkIndex(int i, int n) {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Element is out of bounds");
    }

    public E get(int i) {
        checkIndex(i, size);
        return array[i];
    }

    public E set(int i, E data) {
        checkIndex(i, size);
        array[i] = data;
        return data;
    }

    public E remove(int i) {
        checkIndex(i, size);
        E temp = array[i];

        for(int k = i; k < size-1; k++) {
            array[k] = array[k+1];
        }

        array[size-1] = null;
        size--;
        return temp;
    }

    public Iterator<E> iterator()
    {
        return new ArrListIterator();
    }

    //This class is not static, because it needs to be associated with a
    //specific instance of the ArrayList to access its members
    //Don't put <E> in the class definition here, otherwise Java
    //thinks this is a new generic type (not the one above)
    private class ArrListIterator implements Iterator<E> {
        private int curr;
        private boolean removable = false;

        public ArrListIterator() {
            this.curr = 0;
        }

        public boolean hasNext() {
            return this.curr < size;
        }

        public E next() {
            if (curr == size)
                throw new NoSuchElementException("No next element");
            removable = true;
            return array[curr++];


        }

        public void remove() {
            if (!removable) throw new IllegalStateException("nothing to remove");
            MyArrayList.this.remove(this.curr - 1);
            curr--;
            removable = false;
        }
    }

}
