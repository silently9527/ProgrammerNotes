package cn.silently9527.basic.stack;

import java.util.Iterator;

public class ResizeCapacityArrayStack<T> implements Stack<T> {
    private T[] arr;
    private int size;

    public ResizeCapacityArrayStack(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        if (this.arr.length == size) {
            this.resize(2 * this.arr.length);
        }
        this.arr[size++] = item;
    }

    @Override
    public T pop() {
        T item = this.arr[--size];
        this.arr[size] = null;  //避免游离对象，让垃圾回收器回收无用对象
        if (size > 0 && size == this.arr.length / 4) {
            this.resize(this.arr.length / 2);
        }
        return item;
    }

    private void resize(int newCapacity) {
        Object[] tmp = new Object[newCapacity];
        for (int index = 0; index < size; index++) {
            tmp[index] = arr[index];
        }
        this.arr = (T[]) tmp;
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
