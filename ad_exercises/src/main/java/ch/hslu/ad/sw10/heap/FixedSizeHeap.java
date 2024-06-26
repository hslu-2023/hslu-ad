package ch.hslu.ad.sw10.heap;

public class FixedSizeHeap implements IntegerHeap {

    private final int[] heap;
    private final int capacity;
    private int size;

    public FixedSizeHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity];
    }

    @Override
    public void insert(int num) {
        if (this.isFull()) {
            return;
        }

        int current = size++;
        heap[current] = num;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    @Override
    public int getMax() {
        int max = heap[0];
        heap[0] = heap[--size];
        reorganize(0);
        return max;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isFull() {
        return this.size > this.capacity - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size < 1;
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= (this.size / 2);
    }

    private void swap(int first, int second) {
        int tmp = this.heap[first];
        this.heap[first] = this.heap[second];
        this.heap[second] = tmp;
    }

    private void reorganize(int pos) {
        if (!isLeaf(pos)) {
            int swapPos;
            int leftChildIndex = leftChild(pos);
            int rightChildIndex = rightChild(pos);

            if (rightChildIndex <= this.size) {
                swapPos = this.heap[leftChildIndex] < this.heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
            } else {
                swapPos = leftChildIndex;
            }

            if (this.heap[pos] > this.heap[leftChildIndex] || this.heap[pos] > this.heap[rightChildIndex]) {
                swap(pos, swapPos);
                reorganize(swapPos);
            }
        }
    }

    public int[] getHeap() {
        return heap;
    }
}
