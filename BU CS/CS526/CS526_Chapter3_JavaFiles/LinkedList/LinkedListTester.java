package LinkedList;

/* This class demonstrates the functionality of Singly and Doubly Linked Lists*/

public class LinkedListTester {

    public static void main(String [] args)
    {
        SinglyLinkedList<Integer> linked = new SinglyLinkedList<>();
        for(int i = 0; i < 100; i ++)
        {
            linked.addFirst(i);
        }
        linked.addLast(501);
        System.out.println("Size of list is: " + linked.size());
        System.out.println("First element in list is: " + linked.first());
        System.out.println("Last element in list is: " + linked.last());
        System.out.println(linked);

        //Clone list
        SinglyLinkedList<Integer> newList = linked.clone();
        System.out.println("Are lists equal before removal? " + linked.equals(newList));

        linked.removeFirst();
        System.out.println("Original list: " + linked);
        System.out.println("Cloned list: " + newList);
        System.out.println("Are lists equal after removal? " + linked.equals(newList));

        DoublyLinkedList<Integer> linked2 = new DoublyLinkedList<>();
        for(int i = 0; i < 100; i ++)
        {
            linked2.addFirst(i);
        }
        linked2.addLast(501);
        System.out.println("Size of list is: " + linked2.size());
        System.out.println("First element in list is: " + linked2.first());
        System.out.println("Last element in list is: " + linked2.last());
        System.out.println(linked2);

        linked2.removeLast();
        linked2.removeLast();

        System.out.println("The final size of list after removal is: " + linked2.size());


    }

}
