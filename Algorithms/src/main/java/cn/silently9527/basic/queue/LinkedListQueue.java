package cn.silently9527.basic.queue;

import cn.silently9527.basic.Node;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void enqueue(T item) {
        Node<T> node = new Node<>(item, null);
        if (isEmpty()) {
            first = node; //当队列为空，first和last指向同一个元素
        } else {
            last.setNext(node);
        }
        last = node;
        size++;
    }

    @Override
    public T dequeue() {
        T item = first.getItem();
        first = first.getNext();
        if (isEmpty()) { //当队列为空时，需要把last设置为null
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;  //首节点为空
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
