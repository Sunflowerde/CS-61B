package deque;

import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    public int size = 0;

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;

        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x);
        newNode.next = sentinel;
        newNode.prev = sentinel.prev;

        if (sentinel.prev != sentinel) {
            sentinel.prev.next = newNode;
        } else {
            sentinel.next = newNode;
        }
        sentinel.prev = newNode;

        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel;
        while (p.next != sentinel) {
            returnList.add(p.next.item);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.prev == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        Node removeNode = sentinel.next;
        sentinel.next = removeNode.next;
        if (sentinel.next != null) {
            sentinel.next.prev = sentinel;
        }
        removeNode.next = null;
        removeNode.prev = null;
        return removeNode.item;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while (i != index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return helper(sentinel.next, index);
    }

    private T helper(Node currentNode, int index) {
        if (index == 0) {
            return currentNode.item;
        }
        return helper(currentNode.next, index - 1);
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
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
}
