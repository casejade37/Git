package lectures.resources.lesson6;

import lectures.resources.lesson3.MyNode;

/**
 * A simple queue implementation using Linked List concept
 * top is the front of the queue, so we will remove from top (easy to do)
 * keep tail to easily can add to the end of the queue
 * @param <T>
 */
public class MyQueue<T> {
    private MyNode<T> top;
    private MyNode<T> tail;
    private int size;

    public MyQueue() {
        size = 0;
        top = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T value) {
        MyNode<T> newNode = new MyNode<>(value, top);
        if (top == null) {
            top = newNode;
        }
        if (tail == null) {
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        top = newNode;
    }

    public T dequeue() {
        if (top == null) {
            return null;
        }
        T result = top.getValue();
        top = top.getNext();
        size--;
        if(size == 0)
            tail = null;
        return result;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }

    public String toString() {
        String out = "";
        MyNode <T> curr = this.top;
        while(curr != null) {
            out += curr.getValue() + ", ";
            curr = curr.getNext();
        }
        return out;
    }
}
