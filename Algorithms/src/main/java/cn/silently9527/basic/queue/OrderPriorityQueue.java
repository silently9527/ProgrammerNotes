package cn.silently9527.basic.queue;

import java.util.Comparator;
import java.util.Iterator;

/**
 * 有序数组
 *
 * @param <T>
 */
public class OrderPriorityQueue<T> extends AbstractQueue<T> {

    private T[] queue;
    private int size;

    public OrderPriorityQueue(int max, Comparator<T> comparator) {
        super(comparator);
        this.queue = (T[]) new Object[max];
    }

    @Override
    public void enqueue(T item) {
        queue[size++] = item;
        for (int i = size - 1; i > 1 && less(queue[i], queue[i - 1]); i--) {
            exch(queue, i, i - 1);
        }
    }

    @Override
    public T dequeue() {
        size--;
        T data = queue[size];
        queue[size] = null;
        return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return queue[index++];
            }
        };
    }
}
