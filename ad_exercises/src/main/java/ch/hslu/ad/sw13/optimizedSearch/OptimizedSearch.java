package ch.hslu.ad.sw13.optimizedSearch;

public class OptimizedSearch {

    public static void main(String[] args) {
        System.out.println(stateSearch("ANANAS"));
    }

    /**
     * Searches a character string using an optimised search engine.
     *
     * @param a character string that is searched for the pattern "ANANAS".
     * @return Index of the location or -1 if pattern was not found in a.
     */
    public static int stateSearch(final String a) {

        int i = 0; // index to string a
        String state = ""; // means "nothing found"
        final int notFound = -1;
        do {
            switch (state) {
                case "": // z0
                    if (a.charAt(i) == 'A') {
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;
                case "A": // z1
                    if (a.charAt(i) == 'N') {
                        state = "AN";
                    } else if (a.charAt(i) == 'A') {
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;
                case "AN": // z2
                    if (a.charAt(i) == 'A') {
                        state = "ANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANA": // z3
                    if (a.charAt(i) == 'N') {
                        state = "ANAN";
                    } else if (a.charAt(i) == 'A') {
                        state = "A";
                    } else {
                        state = "";
                    }
                    break;
                case "ANAN": // z4
                    if (a.charAt(i) == 'A') {
                        state = "ANANA";
                    } else {
                        state = "";
                    }
                    break;
                case "ANANA": // z5
                    if (a.charAt(i) == 'S') {
                        state = "ANANAS"; // found -> z6
                    } else if (a.charAt(i) == 'A') {
                        state = "A";
                    } else if (a.charAt(i) == 'N') {
                        state = "ANAN";
                    } else {
                        state = "";
                    }
                    break;
            }
            i++;
        } while (!state.equals("ANANAS") && (i < a.length()));

        if (state.equals("ANANAS")) {
            return (i - "ANANAS".length()); // position of pattern start
        }
        return notFound;

    }
}
