package cn.silently9527.map;

import java.util.Iterator;
import java.util.Objects;

public class ArraySortedMap<K extends Comparable<K>, V> implements SortedMap<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public ArraySortedMap(int capacity) {
        this.keys = (K[]) new Comparable[capacity];
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        int index = this.rank(key);
        if (index < size && key.compareTo(keys[index]) == 0) {
            values[index] = value;
            return;
        }

        for (int j = size; j > index; j--) {
            this.keys[j] = this.keys[j--];
            this.values[j] = this.values[j--];
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = this.rank(key);
        if (index < size && key.compareTo(keys[index]) == 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int index = this.rank(key);
        if (Objects.isNull(keys[index]) || key.compareTo(keys[index]) != 0) {
            return;
        }
        for (int j = index; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        keys[size - 1] = null;
        values[size - 1] = null;
        size--;
    }

    @Override
    public int rank(K key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int compare = key.compareTo(keys[mid]);
            if (compare > 0) {
                lo = mid + 1;
            } else if (compare < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return () -> new Iterator<K>() {
            private int cur;

            @Override
            public boolean hasNext() {
                return cur < size;
            }

            @Override
            public K next() {
                return keys[cur++];
            }
        };
    }

    @Override
    public Iterable<TreeNode> nodes() {
        return null;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }
}
