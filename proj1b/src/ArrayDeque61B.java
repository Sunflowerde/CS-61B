import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private final int INIT_CAPACITY = 8;

    public ArrayDeque61B() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    @Override
    public void addFirst(T x) {
        resize();
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst, items.length);
        size += 1;
    }

    @Override
    public void addLast(T x) {
        resize();
        items[nextLast] = x;
        nextLast = nextOne(nextLast, items.length);
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int begin = nextOne(nextFirst, items.length);
        for (int i = 0; i < size; i++) {
            returnList.add(items[begin]);
            begin = nextOne(begin, items.length);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public int minusOne(int index, int length) {
        return Math.floorMod(index - 1, length);
    }

    public int nextOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }

    private void resize() {
        if (size == items.length) {
            expand();
        } if (size < items.length / 4 && items.length > 8) {
            shrink();
        }
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }

    private void shrink() {
        resizeHelper(items.length / 2);
    }

    private void resizeHelper(int capacity) {
        T[] tmp = items;
        int begin = nextOne(nextFirst, tmp.length);
        int end = minusOne(nextLast, tmp.length);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = nextOne(i, tmp.length)) {
            items[nextLast] = tmp[i];
            nextLast = nextOne(nextLast, capacity);
        }
        items[nextLast] = tmp[end];
        nextLast = nextOne(nextLast, capacity);
    }

    @Override
    public T removeFirst() {
        resize();
        int index = nextOne(nextFirst, items.length);
        T removeItem = items[index];
        items[index] = null;
        size -= 1;
        return removeItem;
    }

    @Override
    public T removeLast() {
        resize();
        int index = minusOne(nextLast, items.length);
        T removeItem = items[index];
        items[index] = null;
        size -= 1;
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(nextOne(nextFirst, items.length) + index, items.length);
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
