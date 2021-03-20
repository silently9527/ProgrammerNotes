package cn.silently9527.map;

import java.util.Objects;

/**
 * 自顶向下 的234树 红黑树实现
 *
 * @param <K>
 * @param <V>
 */
public class RedBlack234RedBlackTreeMapV2<K extends Comparable<K>, V> extends AbstractRedBlackTreeMap<K, V> {

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

        if (isRed(node.left) && isRed(node.right)) {
            upSplit(node);
        }

        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = put(node.right, key, value);
        } else if (compare < 0) {
            node.left = put(node.left, key, value);
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
