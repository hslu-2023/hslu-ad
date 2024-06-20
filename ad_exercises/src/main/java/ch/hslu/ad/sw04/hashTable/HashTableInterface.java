package ch.hslu.ad.sw04.hashTable;

public interface HashTableInterface {
    boolean isFull();
    int size();
    void insert(Integer data);
    Integer search(Integer data);
    boolean delete(Integer data);
}
