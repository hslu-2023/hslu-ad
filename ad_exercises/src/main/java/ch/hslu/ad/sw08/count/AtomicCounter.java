package ch.hslu.ad.sw08.count;

import java.util.concurrent.atomic.AtomicInteger;

public final class AtomicCounter implements Count {
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public int increment() {
        return counter.incrementAndGet();
    }

    @Override
    public int decrement() {
        return counter.decrementAndGet();
    }

    @Override
    public int get() {
        return counter.get();
    }
}

