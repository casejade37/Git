package lectures;

import lectures.resources.lesson7.MyArrayList;
import lectures.resources.lesson7.NodeLinkedList;
import lectures.resources.lesson7.NodeLinkedList.Node;

import java.util.LinkedList;
import java.util.ListIterator;

public class lesson7 {
    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        for (int e: lst) {
            System.out.println(e);
        }

        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(20);
        intList.add(40);
        intList.add(60);
        ListIterator<Integer> iterator = intList.listIterator();
        iterator.add(10);   // Add 10 to the front
        iterator.next();    // Moves to the 20
        iterator.add(100);  // Add 100 after 20 but before 40
        iterator.previous();    // Moves back to the 20 next is 100
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // walk forward
        }
        System.out.println();
        iterator = intList.listIterator(intList.size()); // cursor right after the last elem.
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " "); // walk backward
        }




//        NodeLinkedList<Integer> toSort = new NodeLinkedList<>();
//        toSort.addFirst(3);
//        toSort.addFirst(4);
//        toSort.addFirst(5);
//        sortLL(toSort);
//        System.out.println(toSort);


    }

    public static void sortLL(NodeLinkedList<Integer> list) {
        Node<Integer> marker = list.first();

        while (marker != list.last()) {
            Node<Integer> pivot = list.after(marker);
            int value = pivot.getElement();    // number to be placed
            if (value > marker.getElement())   // pivot is already in correct position
                marker = pivot;
            else {                             // must relocate pivot
                Node<Integer> walk = marker;
                // find leftmost item greater than value
                while (walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk);
                list.remove(pivot);             // remove pivot entry and
                list.addBefore(walk, value);    // reinsert value in front of walk
            }
        }

    }
}

