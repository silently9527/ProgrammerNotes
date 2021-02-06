package cn.silently9527.basic.stack;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ResizeCapacityArrayStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new ResizeCapacityArrayStack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

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