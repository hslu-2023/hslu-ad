package ch.hslu.ad.sw04.hashTable;

import java.util.Arrays;

public class HashTable implements HashTableInterface {
    private final int maxCapacity;
    private Integer[] table;
    private int size;

    public HashTable(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.table = new Integer[maxCapacity];
        this.size = 0;
    }

    private int getIndex(Integer value) {
        return Math.abs(Integer.hashCode(value)) % maxCapacity;
    }

    @Override
    public boolean isFull() {
        return size == maxCapacity;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void insert(Integer value) {

        if (isFull()) {
            throw new IllegalStateException("HashTable is full. Unable to insert value " + value);
        }

        int index = getIndex(value);

        while (table[index] != null) {
            if (table[index].equals(value)) {
                throw new IllegalArgumentException("Duplicate detected at index " + index + " for value " + value);
            }
            index = (index + 1) % maxCapacity;
        }

        table[index] = value;
        size++;
    }

    @Override
    public Integer search(Integer value) {
        int index = getIndex(value);
        int initialIndex = index;

        while (table[index] != null) {
            if (table[index].equals(value)) {
                return table[index];
            }
            index = (index + 1) % maxCapacity;
            if (index == initialIndex) {
                break;
            }
        }
        return null;

    }

    @Override
    public boolean delete(Integer value) {
        int index = getIndex(value);
        int initialIndex = index;

        while (table[index] != null) {
            if (table[index].equals(value)) {
                table[index] = null;
                size--;
                return true;

            }
            index = (index + 1) % maxCapacity;
            if (index == initialIndex) {
                break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "array=" + Arrays.toString(table) +
                '}';
    }

    public Integer[] getTable() {
        return table;
    }
}
