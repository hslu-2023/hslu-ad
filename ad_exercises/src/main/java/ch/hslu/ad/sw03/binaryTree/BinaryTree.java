package ch.hslu.ad.sw03.binaryTree;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T value) {
        root = insertNode(root, value);
    }

    private TreeNode<T> insertNode(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        int compare = value.compareTo(node.getValue());
        if (compare < 0) {
            node.setLeft(insertNode(node.getLeft(), value));
        } else if (compare > 0) {
            node.setRight(insertNode(node.getRight(), value));
        }
        return node;
    }

    @Override
    public T search(T value) {
        return searchNode(root, value).getValue();
    }

    private TreeNode<T> searchNode(TreeNode<T> node, T value) {
        if (node == null || value == null) return null;
        System.out.println("comparing node: " + node.getValue() + " to: " + value);
        if (node.getValue().equals(value)) return node;

        return searchNode(node.getChild(value), value);
    }

    @Override
    public boolean delete(T value) {
        return false;
    }

    @Override
    public void inorder() {
        transverseInOrder(root);
    }

    private void transverseInOrder(TreeNode<T> root) {
        if (root != null) {
            transverseInOrder(root.getLeft());
            System.out.println(root.getValue());
            transverseInOrder(root.getRight());
        }

    }

    @Override
    public void preorder() {
        transversePreOrder(root);
    }

    private void transversePreOrder(TreeNode<T> root) {
        if (root != null) {
            System.out.println(root.getValue());
            transversePreOrder(root.getLeft());
            transversePreOrder(root.getRight());
        }

    }

    @Override
    public void postorder() {
        transversePostOrder(root);
    }

    private void transversePostOrder(TreeNode<T> root) {
        if (root != null) {
            transversePostOrder(root.getLeft());
            transversePostOrder(root.getRight());
            System.out.println(root.getValue());
        }

    }
}
