package ch.hslu.ad.sw08.conclist;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoConcurrentList {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> sharedList = Collections.synchronizedList(new LinkedList<>());

        List<Future<Long>> producerFutures = new ArrayList<>();
        List<Future<Long>> consumerFutures = new ArrayList<>();

        int producerCount = 3;
        int consumerCount = 1;
        int maxRange = 1000;

        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            // Produzenten hinzufügen
            for (int i = 0; i < producerCount; i++) {
                producerFutures.add(executor.submit(new Producer(sharedList, maxRange)));
            }

            long producerTotalSum = 0;
            Iterator<Future<Long>> producerIterator = producerFutures.iterator();

            while (producerIterator.hasNext()) {
                producerTotalSum += producerIterator.next().get();
            }

            // Konsumenten hinzufügen
            for (int i = 0; i < consumerCount; i++) {
                consumerFutures.add(executor.submit(new Consumer(sharedList)));
            }

            long consumerTotalSum = 0;
            Iterator<Future<Long>> consumerIterator = consumerFutures.iterator();

            while (consumerIterator.hasNext()) {
                consumerTotalSum += consumerIterator.next().get();
            }


            System.out.println("Total Sum from Producers: " + producerTotalSum);
            System.out.println("Total Sum from Consumers: " + consumerTotalSum);


        }
    }
}
