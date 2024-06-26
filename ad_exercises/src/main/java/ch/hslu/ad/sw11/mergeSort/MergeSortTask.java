package ch.hslu.ad.sw11.mergeSort;

import ch.hslu.ad.sw10.sort.Sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public final class MergeSortTask extends RecursiveAction {

    private final int THRESHOLD;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public MergeSortTask(final int[] array, int threshold) {
        this(array, 0, array.length, threshold);
    }

    private MergeSortTask(final int[] array, final int min, final int max, int threshold) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.THRESHOLD = threshold;
    }

    @Override
    protected void compute() {
        if (max - min < THRESHOLD) {
            InsertionSort.exec(array, min, max);
        } else {
            final int mid = min + (max - min) / 2;
            invokeAll(new MergeSortTask(array, min, mid, THRESHOLD), new MergeSortTask(array, mid, max, THRESHOLD));
            merge(min, mid, max);
        }
    }

    private void merge(final int min, int mid, int max) {
        // vordere Hälfte von array in Hilfsarray buf kopieren
        int[] buf = Arrays.copyOfRange(array, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            // jeweils das nächstgrösste Element zurückkopieren
            // bei k == max, Rest von buf zurückkopieren, falls vorhanden
            if (k == max || buf[i] < array[k]) {
                array[j] = buf[i];
                i++;
            } else {
                array[j] = array[k];
                k++;
            }
            j++;
        }
    }
}