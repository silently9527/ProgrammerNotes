package cn.silently9527.basic.queue;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;

public class QueueTest {

    @Test
    public void testLinkedListQueue() {
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("遍历：");
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("出队列：");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    @Test
    public void testDisorderPriorityQueue() {
        Queue<Integer> queue = new DisorderPriorityQueue<>(4, Integer::compareTo);
        queue.enqueue(0);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(8);

        System.out.println("出队列：");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    @Test
    public void testOrderPriorityQueue() {
        Queue<Integer> queue = new OrderPriorityQueue<>(4, Integer::compareTo);
        queue.enqueue(0);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(8);

        System.out.println("出队列：");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    @Test
    public void testBinaryHeapPriorityQueue() {
        Queue<Integer> queue = new BinaryHeapPriorityQueue<>(4, Integer::compareTo);
        queue.enqueue(0);
        queue.enqueue(5);
        queue.enqueue(2);
//        queue.enqueue(8);

        System.out.println("出队列：");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
    }

}