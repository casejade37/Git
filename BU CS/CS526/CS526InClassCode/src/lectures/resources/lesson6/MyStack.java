package lectures.resources.lesson6;

import lectures.resources.lesson3.MyNode;

public class MyStack<T> {
    private MyNode<T> top;
    private int size;

    public MyStack() {
        size = 0;
        top = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T value) {
        MyNode<T> newNode = new MyNode<>(value, top);
        size++;
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T result = top.getValue();
        top = top.getNext();
        size--;
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

