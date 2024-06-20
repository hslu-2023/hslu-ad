package ch.hslu.ad.sw02.queue;

import java.util.Arrays;

public class Queue implements Queueable {

    private final int size;

    private char[] arr;

    private int head;

    private int tail;

    public Queue(int size) {
        this.size = size;
        arr = new char[size];
        head = 0;
        tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return arr[head] == '\u0000';
    }

    @Override
    public boolean isFull() {
        return arr[tail] != '\u0000';
    }

    @Override
    public void enqueue(char value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        arr[tail] = value;
        tail++;
        if (tail >= size){
            tail = 0;
        }
    }

    @Override
    public void dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        arr[head] = '\u0000';
        head++;
        if (head >= size){
            head = 0;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
