package cn.silently9527.map;

import cn.silently9527.basic.queue.LinkedListQueue;
import cn.silently9527.basic.queue.Queue;
import cn.silently9527.map.draw.AbstractTreeDrawable;
import cn.silently9527.map.draw.Drawable;

import java.awt.*;
import java.util.Objects;

public abstract class AbstractRedBlackTreeMap<K extends Comparable<K>, V> extends AbstractTreeDrawable implements SortedMap<K, V>, Drawable {
    protected Node root;

    class Node implements TreeNode {
        public static final boolean RED = true;
        public static final boolean BLACK = false;
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;
        public int size = 1;

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        @Override
        public Node getLeft() {
            return this.left;
        }

        @Override
        public Node getRight() {
            return this.right;
        }

        @Override
        public String getValueString() {
            return this.key.toString();
        }

        @Override
        public Color getColor() {
            return color ? Color.RED : Color.BLACK;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    ", size=" + size +
                    '}';
        }
    }


    protected boolean isRed(Node node) {
        if (Objects.isNull(node)) {
            return Node.BLACK;
        }
        return node.color;
    }

    protected int size(Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        node.size = size(node.left) + 1 + size(node.right);
        return node.size;
    }

    //左旋
    protected Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Node.RED;

        size(h);
        size(x);

        return x;
    }

    //右旋
    protected Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Node.RED;

        size(h);
        size(x);

        return x;
    }

    //转换颜色，对应了23树中的节点分裂
    protected void upSplit(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        node.left.color = Node.BLACK;
        node.right.color = Node.BLACK;
        node.color = Node.RED;
    }

    protected void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    @Override
    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("the key can't null");
        }
        Node node = get(root, key);
        return node.value;
    }

    protected Node get(Node node, K key) {
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return this.get(node.right, key);
        } else if (compare < 0) {
            return this.get(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public int size() {
        return root.size;
    }

    @Override
    public int rank(K key) {
        Node node = get(root, key);
        return node.left.size;
    }

    @Override
    protected TreeNode getRoot() {
        return root;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> queue = new LinkedListQueue<>();
        iterableKey(queue, root);
        return queue;
    }

    private void iterableKey(Queue<K> queue, Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        iterableKey(queue, node.left);
        queue.enqueue(node.key);
        iterableKey(queue, node.right);
    }

    @Override
    public Iterable<TreeNode> nodes() {
        Queue<TreeNode> queue = new LinkedListQueue<>();
        iterableNode(queue, root);
        return queue;
    }

    private void iterableNode(Queue<TreeNode> queue, Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        iterableNode(queue, node.left);
        queue.enqueue(node);
        iterableNode(queue, node.right);
    }

    @Override
    public K min() {
        Node min = min(root);
        return min.key;
    }

    @Override
    public K max() {
        Node max = max(root);
        return max.key;
    }

    protected Node min(Node node) {
        if (Objects.isNull(node.left)) {
            return node;
        }
        return min(node.left);
    }

    protected Node max(Node node) {
        if (Objects.isNull(node.right)) {
            return node;
        }
        return max(node.right);
    }


}
