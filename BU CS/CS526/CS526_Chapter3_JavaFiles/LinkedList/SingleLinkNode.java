package LinkedList;

/**
 * Node of a doubly linked list, which stores a reference to its
 * element and to both the previous and next node in the list.
 */
public class SingleLinkNode<E> {

    /** The element stored at this SingleLinkNode */
    private E element;               // reference to the element stored at this SingleLinkNode

    /** A reference to the subsequent SingleLinkNode in the list */
    private SingleLinkNode<E> next;            // reference to the subsequent SingleLinkNode in the list

    /**
     * Creates a SingleLinkNode with the given element and next SingleLinkNode.
     *
     * @param e  the element to be stored
     * @param p  reference to a SingleLinkNode that should precede the new SingleLinkNode
     * @param n  reference to a SingleLinkNode that should follow the new SingleLinkNode
     */
    public SingleLinkNode(E e, SingleLinkNode<E> n) {
        element = e;
        next = n;
    }

    // public accessor methods
    /**
     * Returns the element stored at the SingleLinkNode.
     * @return the element stored at the SingleLinkNode
     */
    public E getElement() { return element; }

    /**
     * Returns the SingleLinkNode that follows this one (or null if no such SingleLinkNode).
     * @return the following SingleLinkNode
     */
    public SingleLinkNode<E> getNext() { return next; }

    // Update methods
    /**
     * Sets the SingleLinkNode's next reference to point to SingleLinkNode n.
     * @param n    the SingleLinkNode that should follow this one
     */
    public void setNext(SingleLinkNode<E> n) { next = n; }
}