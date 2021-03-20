package cn.silently9527.map;

import java.util.Objects;

public class BinaryTreeMap<K extends Comparable<K>, V> implements SortedMap<K, V> {
    private Node root;

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (Objects.isNull(node)) {
            return new Node(key, value);
        }

        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = put(node.right, key, value);
        } else if (compare < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }

    private int size(Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return node.size;
    }


    @Override
    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("key can not null");
        }

        Node node = get(root, key);
        return Objects.isNull(node) ? null : node.value;
    }

    private Node get(Node node, K key) {
        if (Objects.isNull(node)) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return get(node.right, key);
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (Objects.isNull(node)) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            node.left = delete(node.left, key);
        } else {
            if (Objects.isNull(node.left)) {
                return node.right;
            }
            if (Objects.isNull(node.right)) {
                return node.left;
            }

            Node max = max(node.left);
            node.key = max.key;
            node.value = max.value;

            node.left = deleteMax(node.left);
        }
        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }


    @Override
    public int size() {
        return root.size;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Iterable<TreeNode> nodes() {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }


    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node node) {
        if (Objects.isNull(node.left)) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + 1 + size(node.right);
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    public Node deleteMax(Node node) {
        if (Objects.isNull(node.right)) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + 1 + size(node.right);
        return node;
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


    class Node implements TreeNode {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int size = 1;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public TreeNode getLeft() {
            return this.left;
        }

        @Override
        public TreeNode getRight() {
            return this.right;
        }

        @Override
        public String getValueString() {
            return this.key.toString();
        }
    }
}
