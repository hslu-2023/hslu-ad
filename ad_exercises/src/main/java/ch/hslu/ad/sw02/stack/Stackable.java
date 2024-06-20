package ch.hslu.ad.sw02.stack;

public interface Stackable<T> {

    /**
     * Indicates if Array is empty.
     * @return true if is empty, false if it is not empty.
     */
    boolean isEmpty();

    /**
     * Indicates if Array is full.
     * @return true if is full, false if it is not full.
     */
    boolean isFull();

    /**
     * Adds an element to the end of the array.
     * @param element value to be added.
     */
    void push(T element);

    /**
     * Removes an element from the end of the array.
     */
    void pop();

    /**
     * Returns size of the array
     * @return size of the array
     */
    int getSize();


}
