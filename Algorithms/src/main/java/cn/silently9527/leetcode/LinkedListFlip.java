package cn.silently9527.leetcode;

//链表取反
public class LinkedListFlip {

    public static Node flip(Node node) {
        Node first = null;
        while (node != null) {
            Node next = node.next;
            node.next = first;
            first = node;
            node = next;
        }
        return first;
    }


    static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(4, null)));
        Node flip = LinkedListFlip.flip(node);

        while (flip != null) {
            System.out.println(flip.value);
            flip = flip.next;
        }
    }
}
