package LinkedList;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A basic Singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

// modifed for a course assignment

public class SinglyLinkedList<E> {

    // instance variables of the SinglyLinkedList
    /** Sentinel node at the beginning of the list */
    private SingleLinkNode<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private SingleLinkNode<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public SinglyLinkedList() {
    }

    public SingleLinkNode<E> getHeader() {return header;}
    public SingleLinkNode<E> getTrailer() {return trailer;}

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getElement();   // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getElement();    // last element is before trailer
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        SingleLinkNode<E> n = new SingleLinkNode<E>(e,header);
        if(size==0)
        {
            header = trailer = n;
        }else
        {
            header = n;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        SingleLinkNode<E> n = new SingleLinkNode<>(e,null);
        if(size==0)
        {
            header = trailer = n;
        }
        else
        {
            trailer.setNext(n);
            trailer = n;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) return null;                  // nothing to remove

        SingleLinkNode<E> tmp = header;
        header = header.getNext();
        size--;
        return tmp.getElement();             // first element is beyond header
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        SingleLinkNode<E> walk = header;
        while (walk != null) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public SinglyLinkedList<E> clone()
    {
        SinglyLinkedList<E> newlist = new SinglyLinkedList<E>();

        SingleLinkNode<E> curr = this.getHeader();

        while(curr!=null)
        {
            newlist.addLast(curr.getElement());
            curr = curr.getNext();
        }
        return newlist;
    }

    public boolean equals(SinglyLinkedList<E> other)
    {
        if(this.size!=other.size)
            return false;

        SingleLinkNode<E> thisHead = this.getHeader();
        SingleLinkNode<E> otherHead = other.getHeader();
        while(thisHead!=null)
        {
            if(!thisHead.getElement().equals(otherHead.getElement()))
                return false;
            thisHead = thisHead.getNext();
            otherHead = otherHead.getNext();
        }
        return true;
    }


    // added


} //----------- end of SinglyLinkedList class -----------