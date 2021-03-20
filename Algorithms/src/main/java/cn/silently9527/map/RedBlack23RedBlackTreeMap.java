package cn.silently9527.map;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RedBlack23RedBlackTreeMap<K extends Comparable<K>, V> extends AbstractRedBlackTreeMap<K, V> {

    @Override
    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("the key can't null");
        }
        root = put(root, key, value);
        root.color = Node.BLACK;
    }

    private Node put(Node node, K key, V value) {
        if (Objects.isNull(node)) {
            return new Node(key, value, Node.RED);
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = put(node.right, key, value);
        } else if (compare < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            upSplit(node);
        }

        size(node);
        return node;
    }


    @Override
    public void delete(K key) {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }

        root = delete(root, key);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }
    }


    private Node delete(Node node, K key) {
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveToRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else if (compare > 0) {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveToRedRight(node);
            }
            node.right = delete(node.right, key);
        } else {
            if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                return null;
            }

            if (Objects.nonNull(node.left)) {
                Node max = max(node.left);
                node.key = max.key;
                node.value = max.value;
                node.left = deleteMax(node.left);
            } else {
                Node min = min(node.right);
                node.key = min.key;
                node.value = min.value;
                node.right = deleteMin(node.right);
            }
        }
        return balance(node);
    }


//    private Node delete(Node h, Key key) {
//        // assert get(h, key) != null;
//
//        if (key.compareTo(h.key) < 0)  {
//            if (!isRed(h.left) && !isRed(h.left.left))
//                h = moveRedLeft(h);
//            h.left = delete(h.left, key);
//        }
//        else {
//            if (isRed(h.left))
//                h = rotateRight(h);
//            if (key.compareTo(h.key) == 0 && (h.right == null)) ?
//                return null;
//            if (!isRed(h.right) && !isRed(h.right.left))
//                h = moveRedRight(h);
//            if (key.compareTo(h.key) == 0) {
//                Node x = min(h.right);
//                h.key = x.key;
//                h.val = x.val;
//                // h.val = get(h.right, min(h.right).key);
//                // h.key = min(h.right).key;
//                h.right = deleteMin(h.right);
//            }
//            else h.right = delete(h.right, key);
//        }
//        return balance(h);
//    }


    private Node balance(Node h) {
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }

        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }
    }


    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveToRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveToRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }

        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }

    }

    private Node deleteMax(Node node) {
        if (isRed(node.left)) {
            node = rotateRight(node);
        }
        if (Objects.isNull(node.right)) {
            return null;
        }
        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = moveToRedRight(node);
        }
        node.right = deleteMax(node.right);
        return balance(node);
    }

    private Node moveToRedRight(Node node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }
}
