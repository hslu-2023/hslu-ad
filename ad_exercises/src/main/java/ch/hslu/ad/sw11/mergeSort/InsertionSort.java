package ch.hslu.ad.sw11.mergeSort;

public final class InsertionSort {

    /**
     * Privater Konstruktor.
     */
    private InsertionSort() {
    }

    /**
     * Sortiert das int-Array aufsteigend. Zur Anwendung kommt der
     * Sortieralgorithmus "direktes Einfügen".
     *
     * @param array Interger-Array.
     * @param min   der Index des ersten zu sortierenden Elements
     *              (einschliesslich).
     * @param max   der Index des letzten exklusiven Elements, das sortiert werden
     *              soll.
     */
    public static void exec(final int[] array, final int min, final int max) {
        int elt, j;

        for (int i = min; i < max; i++) {
            elt = array[i];      // next elt for insert
            j = i;               // array[min]..array[j-1] already sorted
            while ((j > min) && (array[j - 1] > elt)) {
                array[j] = array[j - 1]; // shift right
                j--;             // go further left
            }
            array[j] = elt;      // insert elt
        }                        // array[min]...array[max-1] sorted
    }

}