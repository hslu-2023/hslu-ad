package ch.hslu.ad.sw08.conclist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Producer implements Callable<Long> {

    private final List list;
    int maxRange;

    public Producer(List list, int maxRange) {
        this.list = list;
        this.maxRange = maxRange;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = 1; i <= maxRange; i++) {
            sum += i;
                list.add(i);
        }
        return sum;
    }
}
