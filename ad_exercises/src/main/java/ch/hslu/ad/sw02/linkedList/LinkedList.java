package ch.hslu.ad.sw02.linkedList;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public T search(final T value) {
        if (this.isEmpty()) {
            throw new IllegalStateException("This list is empty");
        }
        Node<T> head = this.head;

        while (head != null) {
            if (head.getValue().equals(value)) {
                return value;
            }
            head = head.getNext();
        }
        return null;
    }

    public void insertAtHead(final T ...values) {
        for (T value : values) {
            insertAtHead(value);
        }
    }

    private void insertAtHead(final T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public T popAtHead() {
        if (this.isEmpty()) {
            throw new IllegalStateException("This list is empty");
        }
        T value = this.head.getValue();
        this.head = head.getNext();
        size--;

        return value;
    }

    public T removeValue(final T value) {
        if (this.isEmpty()) {
            throw new IllegalStateException("This list is empty");
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                }
                size--;
                return value;
            }
            previous = current;
            current = current.getNext();
        }

        return null;
    }

    public T getHead() {
        return this.head.getValue();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private final class LinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    private static final class Node<T> {

        private final T value;

        private Node<T> next;

        public Node(final T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(final Node<T> next) {
            this.next = next;
        }

    }
}
