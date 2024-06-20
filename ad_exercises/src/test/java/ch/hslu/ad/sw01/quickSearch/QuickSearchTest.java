package ch.hslu.ad.sw01.quickSearch;

import ch.hslu.ad.sw13.quickSearch.QuickSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSearchTest {

    @Test
    void testQuickSearchNotFound() {
        assertEquals(-1, QuickSearch.quickSearch("abcdefghijk", "hello"));
    }

    @Test
    public void testQuickSearchFoundAtStart() {
        assertEquals(0, QuickSearch.quickSearch("hello world", "hel"));
    }

    @Test
    public void testQuickSearchFound() {
        assertEquals(4, QuickSearch.quickSearch("abracadabra", "cad"));
    }

    @Test
    public void testQuickSearchAtEnd() {
        assertEquals(24, QuickSearch.quickSearch("Lorem ipsum dolor sit amet", "et"));
    }

    @Test
    void testOptimalNotFound() {
        assertEquals(-1, QuickSearch.optimalMismatch("abcdefghijk", "hello"));
    }

    @Test
    public void testOptimalAtStart() {
        assertEquals(0, QuickSearch.optimalMismatch("hello world", "hel"));
    }

    @Test
    public void testOptimalFound() {
        assertEquals(4, QuickSearch.optimalMismatch("abracadabra", "cad"));
    }

    @Test
    public void testOptimalAtEnd() {
        assertEquals(24, QuickSearch.optimalMismatch("Lorem ipsum dolor sit amet", "et"));
    }

}