package ch.hslu.ad.sw06.boundedBuffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class BoundedBuffer<T> {
    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;

    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
    }

    public void add(final T item) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(item);
        }
        takeSema.release();
    }

    public T remove() throws InterruptedException {
        takeSema.acquire();
        T item;
        synchronized (queue) {
            item = queue.removeLast();
        }
        putSema.release();
        return item;
    }

    public boolean add(final T item, long timeoutMillis) throws InterruptedException {
        if (!putSema.tryAcquire(timeoutMillis, TimeUnit.MILLISECONDS)) {
            return false;
        }
        synchronized (queue) {
            queue.addFirst(item);
        }
        takeSema.release();
        return true;
    }

    public T remove(long timeoutMillis) throws InterruptedException {
        if (!takeSema.tryAcquire(timeoutMillis, TimeUnit.MILLISECONDS)) {
            return null;
        }
        T elem;
        synchronized (queue) {
           elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public boolean full() {
        return putSema.availablePermits() == 0;
    }

    public int size() {
        return queue.size();
    }
}
