import java.util.ArrayDeque;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int circularIndex(int index) {
        return Math.floorMod(index, items.length);
    }

    @Override
    public void addFirst(T x) {
        if (size <= items.length) {
            items[nextFirst] = x;
            nextFirst = circularIndex(nextFirst - 1);
        }
        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (size <= items.length) {
            items[nextLast] = x;
            nextLast = circularIndex(nextLast + 1);
        }
        size += 1;
    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
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
        if (index >= size) {
            return null;
        }
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
