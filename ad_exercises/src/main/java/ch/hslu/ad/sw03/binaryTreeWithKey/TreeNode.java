package ch.hslu.ad.sw03.binaryTreeWithKey;

public class TreeNode<T extends Comparable<T>> {

    private T value;
    private int hashValue;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        this.hashValue = value.hashCode();
        this.right = null;
        this.left = null;
    }

    public TreeNode<T> getChild(T value) {
        if (value.hashCode() > hashValue) {
            return this.getRight();
        } else {
            return this.getLeft();
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
        this.hashValue = value.hashCode();
    }

    public int getHashValue() {
        return hashValue;
    }
}
