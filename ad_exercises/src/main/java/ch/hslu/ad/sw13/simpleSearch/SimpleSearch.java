package ch.hslu.ad.sw13.simpleSearch;

public class SimpleSearch {
    /**
     * Searches a character string using simple search.
     * @param a character string to be searched.
     * @param p pattern to be searched for.
     * @return index of the location found or -1 if p was not found in a.
     */
    public static int simpleSearch(final String a, final String p) {
        final int maxIndex = a.length() - p.length();
        final int notFound = -1;
        for (int index = 0; index <= maxIndex; index++) {
            boolean success = true;
            for (int j = 0; j < p.length(); j++) {
                if (a.charAt(index + j) != p.charAt(j)) {
                    success = false;
                    break;
                }
            }
            if (success) {
                return index;
            }
        }
        return notFound;
    }
}
