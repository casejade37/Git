package lectures.resources.lesson3;

import java.util.NoSuchElementException;

/**
 * Most basic Singly Linked List Class
 * Only use a single header pointer.
 * @param <E> the type
 */
public class MyLinkedList<E> implements Cloneable {
    private MyNode<E> header;
    private int size; // We could get rid of this, what would we need to change?

    public MyLinkedList() {
        header = null;
    }

    public MyNode<E> getHeader() {
        return header;
    }

    public int getSize() {
        return size;
    }

    public void addToFront(E value) {
        MyNode<E> newFront = new MyNode<>(value, header);
        header = newFront;
        size++;
    }

    public void addToSecond(E value) {
        MyNode<E> newSecond = new MyNode<>(value, header.getNext());
        header.setNext(newSecond);
        size++;
    }


    public void addToEnd(E value) {
        MyNode<E> newEnd = new MyNode<>(value);
        MyNode<E> lastNode = getLastNode();
        if (lastNode != null) {
            lastNode.setNext(newEnd);
        }
        else {
            // No nodes in LinkedList
            header = newEnd;
        }
        size++;
    }

    private MyNode<E> getLastNode() {
        MyNode<E> currentNode = header;
        while(currentNode != null && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public void deleteFromFront() {
        if (header == null) {
            throw new NoSuchElementException();
        }
        header = header.getNext();
        size--;
    }

    public void deleteFromEnd() {
        if (header == null) {
            throw new NoSuchElementException();
        }
        if (header.getNext() == null) {
            header = null;
        } else {
            MyNode<E> currentNode = header;
            while(currentNode != null && currentNode.getNext() != null && currentNode.getNext().getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
        size--;
    }

    public boolean find(E valueToFind) {
        MyNode<E> currentNode = header;
        while(currentNode != null) {
            if (currentNode.getValue() == valueToFind) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        // Check 1: Is other the same object as me?
        // Check 2: Is other a MyLinkedList of the same type as me?
        // Check 3: Is other the same length as me?
        // Check 4: Is each of my nodes = to each of other's nodes
        // Are all of these needed?
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyLinkedList<?>)) {
            return false;
        }
        MyLinkedList<?> otherLinkedList = (MyLinkedList<?>) other;

        if (otherLinkedList.getSize() != size) {
            return false;
        }

        MyNode<E> currentNode = header;
        MyNode<?> otherNode = otherLinkedList.getHeader();
        while (currentNode != null) {
            if (!(currentNode.getValue().equals(otherNode.getValue()))) {
                return false;
            }
            currentNode = currentNode.getNext();
            otherNode = otherNode.getNext();
        }
        return true;
    }

    @Override
    public MyLinkedList<E> clone() throws CloneNotSupportedException {
        MyLinkedList<E> clone = (MyLinkedList<E>) super.clone();

        MyNode<E> currentNode = header;
        while (currentNode != null) {
            clone.addToEnd(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return clone;
    }

    @Override
    public String toString() {
//        must implement ourselves if we want a human readable version
        StringBuilder result = new StringBuilder();
        MyNode<E> currentNode = header;

        while(currentNode != null) {
            result.append(currentNode.getValue())
                    .append(" -> ");
            currentNode = currentNode.getNext();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.addToEnd(3);
        ll.addToEnd(4);
        ll.addToFront(2);
        ll.addToFront(1);
//        System.out.println(ll);
//        System.out.println("Delete from End");
//        ll.deleteFromEnd();
//        System.out.println(ll);
//        System.out.println("Delete from Front");
//        ll.deleteFromFront();
//        System.out.println(ll);
//        System.out.println("Delete from End");
//        ll.deleteFromEnd();
//        System.out.println(ll);
//        System.out.println("Delete from Front");
//        ll.deleteFromFront();
//        System.out.println(ll);
//        System.out.println("Find 3: " + ll.find(3));
//        System.out.println("Add all back");
//        ll.addToEnd(3);
//        ll.addToEnd(4);
//        ll.addToFront(2);
//        ll.addToFront(1);
//        System.out.println(ll);
//        System.out.println("Find 3: " + ll.find(3));

        MyLinkedList<Integer> ll2 = new MyLinkedList<>();
        ll2.addToEnd(3);
        ll2.addToEnd(4);
        ll2.addToFront(2);
        ll2.addToFront(1);
        System.out.println(ll);
        System.out.println(ll2);
        System.out.println(ll.equals(ll2));

        try {
            MyLinkedList<Integer> ll3  = ll.clone();
            System.out.println(ll3);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


    }



}
