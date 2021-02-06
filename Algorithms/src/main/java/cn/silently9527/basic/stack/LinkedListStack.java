package cn.silently9527.basic.stack;

import cn.silently9527.basic.Node;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> first;
    private int size;

    @Override
    public void push(T item) {
        this.first = new Node<>(item, first);
        size++;
    }

    @Override
    public T pop() {
        T item = first.getItem();
        size--;
        first = first.getNext();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.getItem();
                current = current.getNext();
                return item;
            }
        };
    }
}
