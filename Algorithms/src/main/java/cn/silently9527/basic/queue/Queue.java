package cn.silently9527.basic.queue;

public interface Queue<T> extends Iterable<T> {
    void enqueue(T item); //入队列

    T dequeue(); //出队列

    int size();

    boolean isEmpty();
}
