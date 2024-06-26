package ch.hslu.ad.sw08.count;

import java.util.concurrent.Callable;

public class CountTask implements Callable<Integer> {

private final Count counter;
private final int counts;

    public CountTask(Count counter, int counts) {
        this.counter = counter;
        this.counts = counts;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < counts; i++) {
            counter.increment();
        }
        for (int i = 0; i < counts; i++) {
            counter.decrement();
        }
        return counter.get();
    }
}
