package LinkedList;

/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
public class Hw2_p3 {

	// implement reverse method
	// you may want to write a separate method with additional parameters, which is recursive

	/**
	 * reverse a doubly linked list containing integers
	 * Input:
	 * @param intList: a doubly linked list containing integers
	 * Output:
	 * completely reversed intList.
	 */
	/* submitted answer
public static void reverse(DoublyLinkedList<Integer> intList) {
		if (intList.isEmpty()) { // if the list is empty, nothing to reverse
			return;
		}

		DoubleLinkNode<Integer> temp = intList.getHeader(); // store the current head node

		reverse(intList, intList.getHeader()); // call the recursive method

		intList.setHeader(intList.getTrailer()); // set the new head to the old tail node
		intList.setTrailer(temp); // set the new tail to the old head node
		temp.setPrev(null); // set the prev of the new head to null
	}

	private static void reverse(DoublyLinkedList<Integer> intList, DoubleLinkNode<Integer> node) {
		if (node == null) { // base case: we have reached the end of the list
			return;
		}

		// swap the prev and next pointers of the current node
		DoubleLinkNode<Integer> temp = node.getNext();
		node.setNext(node.getPrev());
		node.setPrev(temp);

		// recursively call reverse on the next node
		reverse(intList, node.getPrev());

		// if the current node is the original head node, set it as the new tail node
		if (node.getPrev() == null) {
			intList.setTrailer(node);
		}
	}
	 */

	public static void reverse(DoublyLinkedList<Integer> intList) {
		DoubleLinkNode<Integer> first = intList.getHeader().getNext();
		reverseRecurse(intList, first);
	}

	public static void reverseRecurse(DoublyLinkedList<Integer> intList, DoubleLinkNode<Integer> sentinel) {
		if (sentinel.getNext() != null && sentinel.getNext().getElement() != null) {
			int last = intList.removeLast();
			intList.addBetween(last, sentinel.getPrev(), sentinel);
			reverseRecurse(intList, sentinel);
		}
	}



	// use the main method for testing
	// test with arrays of different lengths
	public static void main(String[] args) {


		DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();

		int[] a = {10, 20, 30, 40, 50};
		for (int i=0; i<a.length; i++) {
			intList.addLast(a[i]);
		}

		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);


		System.out.println("After reverse: " + intList.toString());

		intList = new DoublyLinkedList<>();
		int[] b = {10, 20, 30, 40, 50, 60};
		for (int i=0; i<b.length; i++) {
			intList.addLast(b[i]);
		}
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);

		System.out.println("After reverse: " + intList.toString());

	}

}
