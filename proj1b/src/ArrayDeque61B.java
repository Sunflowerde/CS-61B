import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int INIT_CAPACITY = 8;

    public ArrayDeque61B() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int nextOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }

    private int minusOne(int index, int length) {
        return Math.floorMod(index - 1, length);
    }

    private void resizeHelper(int capacity) {
        T[] tmp = items;
        int begin = nextOne(nextFirst, tmp.length);
        int end = minusOne(nextLast, tmp.length);
        items = (T[]) new Object[capacity];
        for (int i = begin; i != end; i = nextOne(i, tmp.length)) {
            items[nextLast] = tmp[i];
            nextLast = nextOne(nextLast, capacity);
        }
        items[nextLast] = tmp[end];
        nextLast = nextOne(nextLast, capacity);
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }

    private void shrink() {
        resizeHelper(items.length / 2);
    }

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < items.length && items.length > 8) {
            shrink();
        }
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
        for (int i = 0; i < size; i += 1) {
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

    @Override
    public T removeFirst() {
        resize();
        int first = nextOne(nextFirst, items.length);
        T removeItem = items[first];
        items[first] = null;
        size -= 1;
        return removeItem;
    }

    @Override
    public T removeLast() {
        resize();
        int last = minusOne(nextLast, items.length);
        T removeItem = items[last];
        items[last] = null;
        size -= 1;
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > items.length) {
            return null;
        }
        int first = nextOne(nextFirst, items.length);
        int realIndex = Math.floorMod(first + index, items.length);
        return items[realIndex];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
