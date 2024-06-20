package ch.hslu.ad.sw03.binaryTree;

public class TreeNode<T extends Comparable<T>> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public TreeNode<T> getChild(T value) {
        if (value.compareTo(this.value) > 0) {
            return this.getRight();
        } else {
            return this.getLeft();
        }

    }

    public void setChild(TreeNode<T> node) {
        if (node.getValue().compareTo(this.value) > 0) {
            this.right = node;
        } else {
            this.left = node;
        }
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
