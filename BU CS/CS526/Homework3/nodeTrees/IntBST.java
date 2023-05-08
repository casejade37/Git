/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */

package nodeTrees;

import java.util.ArrayList;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	//private int size = 0;

	public IntBST() {	}

	public int size() {
		return size;
	}

	public void setSize(int s) { size = s; }
	
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * 
	 * @param n Node in tree to start printing from
	 */
	
	  public void print(Node<Integer> n){ print ("", n); }
	  
	  public void print(String prefix, Node<Integer> n){
		  if (n != null){
			  print(prefix + "       ", right(n));
			  System.out.println (prefix + ("|-- ") + n.getElement());
			  print(prefix + "       ", left(n));
		  }
	  }
	  
	  
	  public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

	
	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2 
		if (left(n) != null) 
			snapshot.add(left(n)); 
		if (right(n) != null)
			snapshot.add(right(n)); return snapshot; 
	}
	
	public int height(Node<Integer> n) throws IllegalArgumentException { 
		if (isExternal(n)) { return 0; } 
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n)) h = Math.max(h, height(c)); return h + 1;
	}

//	Submitted verison
	/**
	 * This method is used to make a binary search tree using a private recursive helper method
	 * Input:
	 * @param a: an array of integer that are already sorted in non-decreasing order
	 *         Output:
	 * @return a complete binary search tree that contains all integers in the array
	 */
//	public static IntBST makeBinaryTree(int[] a) {
////		create an instance of IntBST
//		IntBST bst = new IntBST();
////		set size of bst to the length of the input array
//		bst.setSize(a.length);
////		call a private helper to recursively build the binary search tree
//		bst.root = buildBST(a, 0, a.length - 1, null);
////		return the binary search tree
//		return bst;
//	}

	/**
	 * This private helper method is used to recursively build the binary search tree by returning nodes in the tree
	 * Input:
	 * @param a: an array of integer that are already sorted in non-decreasing order
	 * @param start: starting index of the subarray currently being processed
	 * @param end: ending index of the subarray currently being processed
	 * @param parent: the parent node of the current node being created
	 *              Output:
	 * @return nodes recursively in the binary serach tree
	 */


//	private static Node<Integer> buildBST(int[] a, int start, int end, Node<Integer> parent) {
////		if the starting index is greater than the ending index, return null because a leaf node has been reached.
//		if (start > end) {
//			return null;
//		}
////		otherwise, find the middle element of the subarray
//		int mid = (start + end) / 2;
////		create a new node with that element
//		Node<Integer> node = new Node<>(a[mid], parent, null, null);
////		set the left child of the new node to the result of a recursive call with the left half of the subarray
//		node.setLeft(buildBST(a, start, mid - 1, node));
////		set the right child of the new node to the result of a recursive call with the right half of the subarray
//		node.setRight(buildBST(a, mid + 1, end, node));
////		return the new node
//		return node;
//	}

//	TA's version
	public static IntBST makeBinaryTreeRecursive(int[] a, int left, int right) {
		IntBST bst = new IntBST();
		int mid = (left + right) / 2;
		bst.addRoot(a[mid]);

		if (left >= right) {
			return bst;
		}

		bst.attach(bst.root, makeBinaryTreeRecursive(a, left, mid - 1),
				makeBinaryTreeRecursive(a, mid + 1, right));
		return bst;
	}

		public static IntBST makeBinaryTree(int[] a) {
			return makeBinaryTreeRecursive(a, 0, a.length - 1);
		}
}

