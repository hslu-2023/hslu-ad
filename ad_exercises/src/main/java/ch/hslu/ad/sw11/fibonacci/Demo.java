package ch.hslu.ad.sw11.fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class Demo {
    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final var n = 42;
        LOG.info("fibo({}) start...", n);

        final var measuredIterativ = measure(Demo::fiboIterative, n);
        LOG.info("Func. iterative : {} ns", measuredIterativ);

        final var measuredRecursive = measure(Demo::fiboRecursive, n);
        LOG.info("Func. recursive : {} ns", measuredRecursive);

        final long measuredConcurrent = measure((__) -> fibonacciConcurrent(n), n);
        LOG.info("Conc. recursive : {} ns", measuredConcurrent);
    }

    private static long fibonacciConcurrent(int n) {
        try (var pool = new ForkJoinPool()) {
            final var task = new FibonacciTask(n);
            return pool.invoke(task);
        }
    }

    private static long measure(Function<Integer, Long> fibo, int n) {
        final var start = System.nanoTime();
        final var result = fibo.apply(n);
        LOG.debug("Fibo Result = %d".formatted(result));
        final var stop = System.nanoTime();
        return (stop - start) / 1_000_000;
    }
}
