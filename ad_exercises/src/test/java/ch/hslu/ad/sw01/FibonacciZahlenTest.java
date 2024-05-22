package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciZahlenTest {

    FibonacciZahlen demo = new FibonacciZahlen();

    @Test
    void testFiboRec1Case0(){
        int result = demo.fiboRec1(0);
        assertEquals(0, result);
    }

    @Test
    void testFiboRec1Case1(){
        int result = demo.fiboRec1(1);
        assertEquals(1, result);
    }

    @Test
    void testFiboRec1Case2(){
        int result = demo.fiboRec1(2);
        assertEquals(1, result);
    }

    @Test
    void testFiboRec1Case8(){
        int result = demo.fiboRec1(8);
        assertEquals(21, result);
    }


}