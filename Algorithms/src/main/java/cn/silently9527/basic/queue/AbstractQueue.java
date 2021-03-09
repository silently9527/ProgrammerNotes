package cn.silently9527.basic.queue;

import java.util.Comparator;

public abstract class AbstractQueue<T> implements Queue<T> {
    private Comparator<T> comparator;

    public AbstractQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean less(T a, T b) {
        return comparator.compare(a, b) < 0;
    }

    public void exch(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
