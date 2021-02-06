package cn.silently9527.basic.stack;

import java.util.Iterator;

public class FixCapacityArrayStack<T> implements Stack<T> {
    private T[] arr;
    private int size;

    public FixCapacityArrayStack(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        this.arr[size++] = item;
    }

    @Override
    public T pop() {
        return this.arr[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
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
                return arr[index++];
            }
        };
    }


}
