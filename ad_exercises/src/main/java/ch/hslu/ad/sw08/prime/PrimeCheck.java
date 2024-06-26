package ch.hslu.ad.sw08.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final long start = System.currentTimeMillis();
        LOG.info("Anzahl Kerne = {}", Runtime.getRuntime().availableProcessors());

        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        List<Future<BigInteger>> results = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            results.add(executorService.submit(new PrimeChecker()));
        }

        int i = 1;

        for (Future<BigInteger> result : results) {
            LOG.info("{}, {}", i, result.get().toString().substring(0, 20));
            i++;
        }
        LOG.info("{} ms", System.currentTimeMillis() - start);
    }

}
