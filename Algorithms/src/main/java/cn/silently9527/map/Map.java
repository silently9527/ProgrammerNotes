package cn.silently9527.map;

import java.util.Set;

public interface Map<K, V> {
    void put(K key, V value);

    V get(K key);

    void delete(K key);

    int size();

    Iterable<K> keys();

    Iterable<TreeNode> nodes();

    default boolean contains(K key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }
}
