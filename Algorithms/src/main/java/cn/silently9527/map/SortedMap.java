package cn.silently9527.map;

public interface SortedMap<K extends Comparable<K>, V> extends Map<K, V> {
    int rank(K key);

    void deleteMin();

    void deleteMax();

    K min();

    K max();
}
