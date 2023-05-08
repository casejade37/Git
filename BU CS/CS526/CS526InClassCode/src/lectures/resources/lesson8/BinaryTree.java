package lectures.resources.lesson8;

public interface BinaryTree<E> extends Tree<E> {
    TreeNode<E> left(TreeNode<E> n) throws IllegalArgumentException;
    TreeNode<E> right(TreeNode<E> n) throws IllegalArgumentException;
    TreeNode<E> sibling(TreeNode<E> n) throws IllegalArgumentException;

}
