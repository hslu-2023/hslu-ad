package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AhaBeispiel {

    private static final Logger LOG =
            LoggerFactory.getLogger(AhaBeispiel.class);

    private static int counter = 0;

    public static void main(String[] args) {
        int[] testValues = {10, 20, 40, 80};
        for (int n : testValues) {
            long startTime = System.currentTimeMillis();
            task(n);
            long endTime = System.currentTimeMillis();
            LOG.info("n = " + n + " | Time taken: " + (endTime - startTime) + " ms" + " | Methods were called : " + counter  + " times");
            counter = 0; // Reset counter for the next iteration
        }
    }

    private static void task1() {
        counter++;
        sleep(5);
    }

    private static void task2() {
        counter++;
        sleep(5);
    }

    private static void task3() {
        counter++;
        sleep(5);
    }

    private static void task(final int n) {
        task1();
        task1();
        task1();
        task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2();
            task2();
            task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3();
                task3(); // T ~ n · n· 2
            }
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
