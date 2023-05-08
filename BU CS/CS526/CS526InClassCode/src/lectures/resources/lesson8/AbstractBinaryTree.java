package lectures.resources.lesson8;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public TreeNode<E> sibling(TreeNode<E> p) {
        TreeNode<E> parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (p == left(parent)) {
            return right(parent);
        }
        else {
            return left(parent);
        }
    }

    @Override
    public int numChildren(TreeNode<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    @Override
    public Iterable<TreeNode<E>> children(TreeNode<E> p) {
        List<TreeNode<E>> children = new ArrayList<>();

        if (left(p) != null)
            children.add(left(p));
        if (right(p) != null)
            children.add(right(p));

        return children;
    }

    public Iterable<TreeNode<E>> inorderTraversal() {
        List<TreeNode<E>> traversedNodes = new ArrayList<>();
        if (!isEmpty())
            inorderTraversalHelper(root(), traversedNodes);   // traverse
        return traversedNodes;
    }

    private void inorderTraversalHelper(TreeNode<E> p, List<TreeNode<E>> listOfNodes) {
        if (left(p) != null)
            inorderTraversalHelper(left(p), listOfNodes);
        listOfNodes.add(p);
        if (right(p) != null)
            inorderTraversalHelper(right(p), listOfNodes);
    }


}
