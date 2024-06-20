package ch.hslu.ad.sw04.hashTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable(10);
    }

    @Test
    public void testInsert() {
        hashTable.insert(1);
        hashTable.insert(2);
        hashTable.insert(3);

        assertEquals(null, hashTable.getTable()[0]);
        assertEquals(1, hashTable.getTable()[1]);
        assertEquals(2, hashTable.getTable()[2]);
        assertEquals(3, hashTable.getTable()[3]);
    }

    @Test
    public void testDuplicateInsertion() {
        hashTable.insert(1);
        final Exception e = assertThrows(IllegalArgumentException.class, () -> hashTable.insert(1)); // Duplicate insertion
        assertEquals("Duplicate detected at index 1 for value 1", e.getMessage());
        assertEquals(1, hashTable.search(1));
    }

    @Test
    public void testDeletion() {
        hashTable.insert(1);
        hashTable.insert(2);
        hashTable.insert(3);

        hashTable.delete(2);

        assertNull(hashTable.search(2));
        assertEquals(1, hashTable.search(1));
        assertEquals(3, hashTable.search(3));
    }

    @Test
    public void testCollisionHandling() {
        hashTable.insert(1);
        hashTable.insert(11); // This should cause a collision

        assertEquals(1, hashTable.getTable()[1]);
        assertEquals(11, hashTable.getTable()[2]);
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < 10; i++) {
            hashTable.insert(i);
        }

        assertTrue(hashTable.isFull());
        assertEquals(10, hashTable.size());
    }

    @Test
    public void testFullHashTableInsertion() {
        for (int i = 0; i < 10; i++) {
            hashTable.insert(i);
        }

        final Exception e = assertThrows(IllegalStateException.class, () -> hashTable.insert(11));
        assertEquals("HashTable is full. Unable to insert value 11", e.getMessage());
        assertNull(hashTable.search(11));
    }

    @Test
    public void testSize() {
        assertEquals(0, hashTable.size());

        hashTable.insert(1);
        assertEquals(1, hashTable.size());

        hashTable.insert(2);
        assertEquals(2, hashTable.size());
    }
}