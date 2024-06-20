package ch.hslu.ad.sw03.binaryTree;

public interface Tree<T extends Comparable<T>> {
    void insert(T value);
    T search(T value);
    boolean delete(T value);
    void inorder();
    void preorder();
    void postorder();

}
