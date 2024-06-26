package ch.hslu.ad.sw10.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Sort {

    private static final Logger LOG = LoggerFactory.getLogger(Sort.class);

    public static void main(String[] args) {

        int[] sizes = {500_000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] randomArray = new int[size];

            for (int i = 0; i < size; i++) {
                randomArray[i] = rand.nextInt();
            }

            LOG.info("Array Size: {}", size);

            long start;

            start = System.currentTimeMillis();
            insertionSort(randomArray.clone());
            LOG.info("Random array insertionSort: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            insertionSort2(randomArray.clone());
            LOG.info("Random array insertionSort2: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            selectionSort(randomArray.clone());
            LOG.info("Random array selectionSort: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            bubbleSort(randomArray.clone());
            LOG.info("Random array bubbleSort: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            bubbleSort2(randomArray.clone());
            LOG.info("Random array bubbleSort2: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            shellSort(randomArray.clone());
            LOG.info("Random array shellSort: {} ms", System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            quickSort(randomArray.clone());
            LOG.info("Random array quickSort: {} ms", System.currentTimeMillis() - start);

            LOG.info("");
        }


    }

    public static int[] insertionSort(final int[] a) {
        for (int i = 1; i < a.length; i++) {
            int elt = a[i];
            int j = i;
            while ((j > 0) && (a[j - 1] > elt)) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = elt;
        }

        return a;
    }

    public static int[] insertionSort2(final int[] a) {
        int elt;
        int j;

        int[] dummyArray = new int[a.length + 1];
        System.arraycopy(a, 0, dummyArray, 1, a.length);

        for (int i = 2; i < dummyArray.length; i++) {
            elt = dummyArray[i]; // next elt for insert
            dummyArray[0] = elt; // dummy - element
            j = i; // a[1] ... a[j-1] already sorted

            while (dummyArray[j - 1] > elt) {
                dummyArray[j] = dummyArray[j - 1]; // shift right
                j--; // go further left
            }

            dummyArray[j] = elt; // insert elt
        } // a[1] ... a[j] sorted

        System.arraycopy(dummyArray, 1, a, 0, a.length); // copy array back to source array
        return a;
    }

    public static int[] selectionSort(final int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static int[] bubbleSort(final int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < (a.length - i); j++) {
                if (a[j - 1] > a[j]) {
                    // swap elements
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }

            }
        }
        return a;
    }

    public static int[] bubbleSort2(final int[] a) {
        int n = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return a;
    }

    public static int[] shellSort(final int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // loop through sublists with gap size
            for (int i = gap; i < array.length; i++) {
                // insertion sort for each sublist
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public static void quickSort(final int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(final int[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        int pivot = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < pivot) {
                up++; // suche größeres (>=) Element von links an
            }
            while ((a[down] >= pivot) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne Trennelement
    }

    private static void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

}