package ch.hslu.ad.sw10.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    FixedSizeHeap fixedSizeHeap;

    @BeforeEach
    void setUp(){
        fixedSizeHeap = new FixedSizeHeap(5);
    }


    @Test
    void insert() {
        fixedSizeHeap.insert(7);
        fixedSizeHeap.insert(9);
        fixedSizeHeap.insert(4);

        assertEquals(3, fixedSizeHeap.size());
        assertEquals("[4, 9, 7, 0, 0]", Arrays.toString(fixedSizeHeap.getHeap()));
    }

    @Test
    void getMax() {
        fixedSizeHeap.insert(7);
        fixedSizeHeap.insert(9);
        fixedSizeHeap.insert(4);

        assertEquals(4, fixedSizeHeap.getMax());
    }

    @Test
    void size() {
    }

    @Test
    void isFull() {
    }

    @Test
    void isEmpty() {
    }
}