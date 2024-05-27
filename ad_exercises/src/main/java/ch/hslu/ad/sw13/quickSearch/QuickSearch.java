package ch.hslu.ad.sw13.quickSearch;

public class QuickSearch {
    /**
     * Searches a character string using quickSearch.
     *
     * @param a character string that is searched.
     * @return index of the location or -1 if pattern was not found in a.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];

        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        // search
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n));
        // (position at i not completely checked) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }

    public static int optimalMismatch(String a, String p) {
        int n = a.length();
        int m = p.length();
        int range = 256; // ASCII range
        int[] shift = new int[range];

        // init shift array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        // overwrite fields according to pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        // search
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch

                // move mismatch in pattern one forward
                int temp = 0;
                shift[j] = temp;
                shift[j + 1] = shift[j];
                shift[j] = temp;

                if (i + m < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && (i + m <= n));

        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found, starting at i
        } else {
            return -1; // pattern not found
        }
    }
}
