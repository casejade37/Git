package lectures.resources.lesson8;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    TreeNode<E> root();
    TreeNode<E> parent(TreeNode<E> n) throws IllegalArgumentException;
    Iterable<TreeNode<E>> children(TreeNode<E> n) throws IllegalArgumentException;
    int numChildren(TreeNode<E> n) throws IllegalArgumentException;
    boolean isInternal(TreeNode<E> n) throws IllegalArgumentException;
    boolean isRoot(TreeNode<E> n) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<TreeNode<E>> TreeNodes();

}
