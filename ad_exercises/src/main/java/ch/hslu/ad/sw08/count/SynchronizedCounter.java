package ch.hslu.ad.sw08.count;

public class SynchronizedCounter implements Count{
    private int counter = 0;

    @Override
    public synchronized int increment() {
        return counter++;
    }

    @Override
    public synchronized int decrement() {
        return counter--;
    }

    @Override
    public synchronized int get() {
        return counter;
    }
}
