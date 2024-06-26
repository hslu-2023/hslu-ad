package ch.hslu.ad.sw10.heap;

public interface IntegerHeap {
    void insert(int element);

    int getMax();

    int size();

    boolean isFull();

    boolean isEmpty();
}
