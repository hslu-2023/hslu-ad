package ch.hslu.ad.sw02.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    MyStack stack;

    @Test
    void isEmptyTestTrue() {
        stack = new MyStack(10);
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushTest() {
        stack = new MyStack(10);
        stack.push("test");
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushTestFull() {
        stack = new MyStack(1);
        stack.push("test");
        final Exception e = assertThrows(IllegalStateException.class, () -> stack.push("test2"));
        assertEquals("Stack is full. Element can not be added until some space is free", e.getMessage());
    }

    @Test
    void popTest() {
        stack = new MyStack(10);
        stack.push("test");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void popTestEmpty() {
        stack = new MyStack(1);
        final Exception e = assertThrows(IllegalStateException.class, () -> stack.pop());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    void getSizeTest() {
        stack = new MyStack(10);
        assertEquals(10, stack.getSize());
    }
}