package ch.hslu.ad.sw02.stack;

public class MyStack<T> implements Stackable<T> {

    private final int size;

    private int nextIndex;

    private Object[] arr;


    public MyStack(int size) {
        this.size = size;
        this.nextIndex = 0;
        this.arr = new Object[size];
    }


    @Override
    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    @Override
    public boolean isFull() {
        return nextIndex >= size;
    }

    @Override
    public void push(T element) {
        if (isFull()){
            throw new IllegalStateException("Stack is full. Element can not be added until some space is free");
        }
        arr[nextIndex] = element;
        nextIndex++;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        arr[nextIndex-1] = null;
        nextIndex--;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
