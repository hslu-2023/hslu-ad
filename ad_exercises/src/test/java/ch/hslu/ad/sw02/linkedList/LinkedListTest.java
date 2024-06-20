package ch.hslu.ad.sw02.linkedList;

import ch.hslu.ad.sw02.linkedList.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void insertAtHeadTest() {
        list.insertAtHead(11, 13);
        assertEquals(2, list.size());
        assertEquals(13, list.getHead());
    }

    @Test
    void insertTest() {
        list.insertAtHead(11, 13, 19, 20, 2, 10);
        assertEquals(6, list.size());
        assertEquals(10, list.getHead());
    }

    @Test
    void removeAtHeadTest() {
        list.insertAtHead(11, 13, 14);
        list.popAtHead();
        assertEquals(2, list.size());
        assertEquals(13, list.getHead());
    }

    @Test
    void searchTest() {
        list.insertAtHead(11, 13, 14);
        assertEquals(11, list.search(11));
        assertEquals(13, list.search(13));
        assertEquals(14, list.search(14));
        assertEquals(null, list.search(10));
    }

    @Test
    void removeTest() {
        list.insertAtHead(11, 13, 14);
        assertEquals(14, list.removeValue(14));
        assertEquals(2, list.size());
    }

    @Test
    void getTest() {
        list.insertAtHead(11, 13, 14);
        assertEquals(13, list.get(1));
    }

    @Test
    void getSize() {
    }
}