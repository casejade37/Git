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

//Another singly linked list but now we are using Node as a private Nested class instead of as a separate
//File
public class SinglyLinkedListV2<E> {

    // instance variables of the SinglyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public SinglyLinkedListV2() {
    }

    public Node<E> getHeader() {return header;}
    public Node<E> getTrailer() {return trailer;}

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
        Node<E> n = new Node<E>(e,header);
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
        Node<E> n = new Node<>(e,null);
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

        Node<E> tmp = header;
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
        Node<E> walk = header;
        while (walk != null) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public SinglyLinkedList<E> clone()
    {
        SinglyLinkedList<E> newlist = new SinglyLinkedList<E>();

        Node<E> curr = this.getHeader();

        while(curr!=null)
        {
            newlist.addLast(curr.getElement());
            curr = curr.getNext();
        }
        return newlist;
    }


    // added

    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private class Node<E> {

        /** The element stored at this Node */
        private E element;               // reference to the element stored at this Node

        /** A reference to the subsequent Node in the list */
        private Node<E> next;            // reference to the subsequent Node in the list

        /**
         * Creates a Node with the given element and next Node.
         *
         * @param e  the element to be stored
         * @param p  reference to a Node that should precede the new Node
         * @param n  reference to a Node that should follow the new Node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // public accessor methods
        /**
         * Returns the element stored at the Node.
         * @return the element stored at the Node
         */
        public E getElement() { return element; }

        /**
         * Returns the Node that follows this one (or null if no such Node).
         * @return the following Node
         */
        public Node<E> getNext() { return next; }

        // Update methods
        /**
         * Sets the Node's next reference to point to Node n.
         * @param n    the Node that should follow this one
         */
        public void setNext(Node<E> n) { next = n; }
    }

} //----------- end of SinglyLinkedList class -----------