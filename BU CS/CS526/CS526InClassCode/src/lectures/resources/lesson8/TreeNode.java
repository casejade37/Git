package lectures.resources.lesson8;

import java.util.ArrayList;
import java.util.List;

/**
 * Node for a Tree
 */
public class TreeNode<E> {
    private E value;
    private List<TreeNode<E>> children;
    private TreeNode<E> parent;
    public TreeNode(E value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(E value) {
        children.add(new TreeNode<>(value));
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public List<TreeNode<E>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<E>> children) {
        this.children = children;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }
}
