package lectures.resources.lesson8;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(TreeNode <E> n) {
        return numChildren(n) > 0;
    }
    public boolean isExternal(TreeNode<E> n) {
        return numChildren(n) == 0;
    }
    public boolean isRoot(TreeNode<E> n) {
        return n == root();
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(TreeNode<E> n) throws IllegalArgumentException {
        if (isRoot(n))
            return 0;
        else
            return 1 + depth(parent(n));
    }

    public int height(TreeNode<E> n) throws IllegalArgumentException {
        int h = 0;	// base case if n is external
        for (TreeNode<E> child : children(n))
            h = Math.max(h, 1 + height(child));
        return h;
    }
}
