package cn.silently9527.basic.stack;

import org.junit.Test;

import java.util.Iterator;

public class FixCapacityArrayStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new FixCapacityArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("遍历栈：");
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("弹出：");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}