package lectures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lesson6 {
    public static void main(String[] args) {
        stackTest();
        queueTest();
    }

    public static void stackTest() {
        Stack<Character> stack = new Stack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        Character top = stack.pop();
        System.out.println("Print after pop " + top);
        System.out.println("Peek and don't remove " + stack.peek());
        System.out.println("Pop and Print " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
        System.out.println("Size " + stack.size());
    }

    public static void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.offer(4);
        System.out.println("Front element is: " + queue.peek() + " (not removed)");
        System.out.println("Front element is: " + queue.poll() + " (removed)");
        System.out.println("Front element is: " + queue.peek() + " (not removed)");
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Number of elements is " + queue.size());

    }
}
