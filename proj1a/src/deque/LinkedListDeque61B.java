package deque;

import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    @Override
    public void addFirst(T x) {

    }

    @Override
    public void addLast(T x) {

    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }

    private Node sentinel;

    public class Node {
        T item;
        Node prev;
        Node next;

        Node(T item) {
            this.item = item;
        }
    }

    public LinkedListDeque61B() {
        Node sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
}
