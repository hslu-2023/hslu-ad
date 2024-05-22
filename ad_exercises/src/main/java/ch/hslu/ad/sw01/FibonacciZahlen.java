package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class FibonacciZahlen {

    private static final Logger LOG =
            LoggerFactory.getLogger(FibonacciZahlen.class);

    public static Map<Integer, Integer> fibonacciZahlen;

    public static void main(String[] args) {
        FibonacciZahlen fibonacci = new FibonacciZahlen();
        fibonacci.measureTime(50);
    }

    public FibonacciZahlen() {
        this.fibonacciZahlen = new HashMap<>();
    }

    public static int fiboRec1(final int n) {
        // Rekursionsbasis
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Rekursionsvorschrift
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public static int fiboRec2(final int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (fibonacciZahlen.containsKey(n)) {
            return fibonacciZahlen.get(n);
        }

        int result = fiboRec2(n - 1) + fiboRec2(n - 2);
        fibonacciZahlen.put(n, result);

        return result;
    }

    public static int fiboIter(final int n) {
        int previous = 0;
        int current = 1;
        int temp;

        for (int i = 0; i < n; i++) {
            temp = previous;
            previous = current;
            current = previous + temp;
        }

        return previous;
    }

    public static void measureTime(int n) {
        long start;
        long end;
        long difference;

        start = System.currentTimeMillis();
        fiboRec1(n);
        end = System.currentTimeMillis();
        difference = end - start;
        LOG.info("fiboRec1: {} ms", difference);

        start = System.currentTimeMillis();
        fiboRec2(n);
        end = System.currentTimeMillis();
        difference = end - start;
        LOG.info("fiboRec2: {} ms", difference);

        start = System.currentTimeMillis();
        fiboIter(n);
        end = System.currentTimeMillis();
        difference = end - start;
        LOG.info("fiboIter: {} ms", difference);
    }
}
