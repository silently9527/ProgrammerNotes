package cn.silently9527.basic.queue;

import java.util.Comparator;
import java.util.Iterator;

public class BinaryHeapPriorityQueue<T> extends AbstractQueue<T> {
    private T[] queue;
    private int size;

    public BinaryHeapPriorityQueue(int max, Comparator<T> comparator) {
        super(comparator);
        this.queue = (T[]) new Object[max + 1];
    }

    @Override
    public void enqueue(T item) {
        this.queue[++size] = item;
        this.swim(size);
    }

    @Override
    public T dequeue() {
        T max = this.queue[1];
        exch(this.queue, 1, size--);
        this.queue[size + 1] = null; //释放内存
        this.sink(1);
        return max;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
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


    private void swim(int k) {
        while (k > 1 && less(queue[k / 2], queue[k])) {
            exch(queue, k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int i = 2 * k;
            if (i < size && less(queue[i], queue[i + 1])) {
                i++;
            }
            if (less(queue[i], queue[k])) {
                break;
            }
            exch(queue, i, k);
            k = i;
        }
    }
}
