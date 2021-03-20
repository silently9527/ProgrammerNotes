package cn.silently9527.map;

import java.util.Objects;

/**
 * 自底向上的 234树 红黑树实现
 * @param <K>
 * @param <V>
 */
public class RedBlack234RedBlackTreeMap<K extends Comparable<K>, V> extends AbstractRedBlackTreeMap<K, V> {

    @Override
    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("the key can't null");
        }
        root = put2(root, key, value);
        root.color = Node.BLACK;
    }

    //实现方式 1
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

        //处理图B对应的情况
        if (isRed(node.left) && isRed(node.left.right)) {
            node.left = rotateLeft(node.left);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        //处理图D对应的情况
        if (isRed(node.right) && isRed(node.right.left)) {
            node.right = rotateRight(node.right);
        }

        if (isRed(node.right) && isRed(node.right.right)) {
            node = rotateLeft(node);
        }

        //处理图F对应的情况
        if ((isRed(node.left) && isRed(node.right))
                && (
                (Objects.nonNull(node.left) && isRed(node.left.left))
                        || (Objects.nonNull(node.left) && isRed(node.left.right))
                        || (Objects.nonNull(node.right) && isRed(node.right.left))
                        || (Objects.nonNull(node.right) && isRed(node.right.right))
        )
        ) {
            upSplit(node);
        }

        size(node);
        return node;
    }

    //保证只存在左边红色  简化版本
    private Node put2(Node node, K key, V value) {
        if (Objects.isNull(node)) {
            return new Node(key, value, Node.RED);
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = put2(node.right, key, value);
        } else if (compare < 0) {
            node.left = put2(node.left, key, value);
        } else {
            node.value = value;
        }


        //简化  为了保证只存在图B的情况，遇到右边红色的就进行左旋
        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        //处理图F对应的情况
        if ((isRed(node.left) && isRed(node.right))
                && (
                (Objects.nonNull(node.left) && isRed(node.left.left))
                        || (Objects.nonNull(node.left) && isRed(node.left.right))
                        || (Objects.nonNull(node.right) && isRed(node.right.left))
                        || (Objects.nonNull(node.right) && isRed(node.right.right))
        )
        ) {
            upSplit(node);
        }

        size(node);
        return node;
    }


    @Override
    public void delete(K key) {

    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }
}
