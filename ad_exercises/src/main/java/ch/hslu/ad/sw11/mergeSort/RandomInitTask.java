package ch.hslu.ad.sw11.mergeSort;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomInitTask extends RecursiveAction {

    private static final int THRESHOLD = 5;
    private final int[] array;
    private final int min;
    private final int max;
    private final int rdMax;

    /**
     * Erzeugt einen Teil-Array-Init Task.
     *
     * @param array    Interger-Array.
     * @param rndBound maximaler Random-Wert-1.
     */
    public RandomInitTask(final int[] array, final int rndBound) {
        this(array, 0, array.length, rndBound);
    }

    private RandomInitTask(final int[] array, final int min, final int max, final int rdBound) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.rdMax = rdBound;
    }

    @Override
    protected void compute() {
        if ((max - min) <= THRESHOLD) {
            for (int i = min; i < max; i++) {
                array[i] = ThreadLocalRandom.current().nextInt(rdMax);
            }
        } else {
            final int mid = min + (max - min) / 2;
            RandomInitTask left = new RandomInitTask(array, min, mid, rdMax);
            RandomInitTask right = new RandomInitTask(array, mid, max, rdMax);
            invokeAll(left, right);
        }
    }
}
