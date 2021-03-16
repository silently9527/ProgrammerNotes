package cn.silently9527.map;

import java.util.Iterator;
import java.util.Optional;

public class LinkedMap<K, V> implements Map<K, V> {
    private Node first;
    private int size;

    @Override
    public void put(K key, V value) {
        Optional<Node> optionalNode = searchNode(key);

        if (optionalNode.isPresent()) {
            optionalNode.get().value = value;
            return;
        }
        this.first = new Node(key, value, first);
        size++;
    }

    @Override
    public V get(K key) {
        return searchNode(key).map(node -> node.value).orElse(null);
    }

    public Optional<Node> searchNode(K key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(K key) {
//        for (Node node = first, preNode = null; node != null; preNode = node, node = node.next) {
//            if (node.key.equals(key)) {
//                if (Objects.isNull(preNode)) {
//                    first = first.next;
//                } else {
//                    preNode.next = node.next;
//                }
//            }
//        }

        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                Node next = node.next;
                node.key = next.key;
                node.value =next.value;
                node.next = next.next;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return () -> new Iterator<K>() {
            private Node cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public K next() {
                K key = this.cur.key;
                this.cur = cur.next;
                return key;
            }
        };
    }


    class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
