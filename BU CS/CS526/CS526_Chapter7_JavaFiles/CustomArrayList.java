package L7;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<E> implements List<E>,Iterable<E>
{
    private E [] arr;
    private int size;
    private static final int DEFAULT_CAPACITY=10;

    public CustomArrayList()
    {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return this.size==0;
    }

    protected void resize()
    {
        E [] tmp = (E[]) new Object[arr.length*2];
        for(int i = 0; i < this.size;i++)
        {
            tmp[i] = arr[i];
        }
        this.arr = tmp;
    }

    public void add(int i, E data)
    {
        if(this.size==arr.length)
            resize();
        checkIndex(i,this.size+1);
        for(int k = this.size-1;k >=i;i--)
        {
            this.arr[k+1] = this.arr[k];
        }
        this.arr[i] = data;
        this.size++;
    }

    protected void checkIndex(int i,int n)
    {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Element is out of bounds");
    }

    public E get(int i)
    {
        checkIndex(i,this.size);
        return this.arr[i];
    }

    public void set(int i, E data)
    {
        checkIndex(i,this.size);
        this.arr[i] = data;
    }

    public E remove(int i)
    {
        checkIndex(i,this.size);
        E temp = this.arr[i];
        for(int k = i; k < this.size-1;k++)
        {
            this.arr[k] = this.arr[k+1];
        }
        this.arr[this.size-1] = null;
        this.size--;
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
    private class ArrListIterator implements Iterator<E>
    {
        private int curr;
        private boolean removable = false;
        public ArrListIterator()
        {
            this.curr=0;
        }
        public boolean hasNext()
        {
            return this.curr < size;
        }
        public E next()
        {
             if(curr==size)
                 throw new NoSuchElementException("No next element");
             removable = true;
             return arr[curr++];


        }
        public void remove()
        {
            if(!removable) throw new IllegalStateException("nothing to remove");
            CustomArrayList.this.remove(this.curr-1);
            curr--;
            removable = false;
        }

    }




}