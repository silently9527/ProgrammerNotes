package cn.silently9527.basic.stack;

public interface Stack<T> extends Iterable {
    void push(T item); //向栈添加元素

    T pop(); //从栈中弹出

    boolean isEmpty();

    int size(); //返回元素的个数
}
