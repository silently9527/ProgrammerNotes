package cn.silently9527.basic.queue;

import java.util.Comparator;
import java.util.Iterator;

/**
 * 无序数组
 *
 * @param <T>
 */
public class DisorderPriorityQueue<T> extends AbstractQueue<T> {

    private T[] queue;
    private int size;

    public DisorderPriorityQueue(int max, Comparator<T> comparator) {
        super(comparator);
        this.queue = (T[]) new Object[max];
    }

    @Override
    public void enqueue(T item) {
        queue[size++] = item;
    }

    @Override
    public T dequeue() {
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (less(queue[index], queue[i])) {
                index = i;
            }
        }
        size--;
        exch(queue, index, size);
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
