package ch.hslu.ad.sw13.kmpSearch;

public class KmpSearch {

    public static void main(String[] args) {
        printArray("ANANAS", initNext("ANANAS"));
        printArray("EISBEIN", initNext("EISBEIN"));
        System.out.println(kmpSearch("abcaaabcacaabcaabaababcabcaaa", "abcaab"));
    }

    /**
     * Creates a pattern machine for the pattern.
     *
     * @param p pattern to be searched for later.
     * @return pattern machine in the form of an int array.
     */
    private static int[] initNext(final String p) {
        final int m = p.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        // special value! (-1 = no reference to a following state)
        do {
            if ((j == -1) || (p.charAt(i) == p.charAt(j))) {
                // (j == -1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }

    /**
     * Searches a character string using KMP algorithm.
     *
     * @param a character string that is searched for the pattern p.
     * @param p pattern to be searched for.
     * @return Index of the location or -1 if pattern was not found in a.
     */
    public static int kmpSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        int i = 0; // index to string a
        int j = 0; // index to pattern p respectively state
        // 1. generate next
        int[] next = initNext(p);
        // 2. search for p
        do {
            if ((j == -1) || (a.charAt(i) == p.charAt(j))) { // (j == -1) first!
                i++; // process next character
                j++;
            } else {
                j = next[j]; // go to next state
            }
        } while ((j < m) && (i < n));
        if (j == m) {
            return (i - m); // pattern found: index to position in a
        } else {
            return -1; // pattern not found
        }
    }

    /**
     * Prints the values of an array.
     * @param name what you would like to print the array name as.
     * @param array array to be printed
     */
    public static void printArray(String name, int[] array) {
        System.out.print(name + " :[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
