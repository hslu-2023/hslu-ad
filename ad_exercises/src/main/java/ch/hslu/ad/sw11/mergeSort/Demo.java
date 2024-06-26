package ch.hslu.ad.sw11.mergeSort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;

public class Demo {
    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int[] testData = new int[]{10, 1_000_000, 5_000_000, 10_000_000, 50_000_000};
        final int threshold = 10;

        for (int size : testData) {
            final int[] arrayOriginal = new int[size];
            try (final ForkJoinPool pool = new ForkJoinPool()) {
                final RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
                pool.invoke(initTask);

                LOG.info("Array size: {}", size);

                final long measuredConcurrent = measureSort(arr -> mergesortConcurrent(arr, pool, threshold), arrayOriginal.clone(), size);
                LOG.info("Concurrent Mergesort: {} ms", measuredConcurrent);

                final long measuredRecursive = measureSort(Demo::mergesortRecursive, arrayOriginal.clone(), size);
                LOG.info("Mergesort                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           Recursive: {} ms", measuredRecursive);
            } finally {
                // Executor shutdown
            }
        }
    }

    private static void mergesortConcurrent(int[] array, ForkJoinPool pool, int threshold) {
        final MergeSortTask sortTask = new MergeSortTask(array, threshold);
        pool.invoke(sortTask);
    }

    private static void mergesortRecursive(int[] array) {
        MergeSortRecursive.mergeSort(array);
    }

    private static long measureSort(Consumer<int[]> sortFunction, int[] array, int size) {
        int[] arrayCopy = Arrays.copyOf(array, size);
        final long start = System.nanoTime();
        sortFunction.accept(arrayCopy);
        final long stop = System.nanoTime();
        return (stop - start) / 1_000_000;
    }
}
