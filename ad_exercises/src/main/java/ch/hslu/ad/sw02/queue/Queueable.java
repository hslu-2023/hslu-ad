package ch.hslu.ad.sw02.queue;

public interface Queueable {
    boolean isEmpty();

    boolean isFull();

    void enqueue(char value);

    void dequeue();

    int getSize();
}
