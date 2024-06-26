package ch.hslu.ad.sw08.conclist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Long> {

    private final List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }
}
