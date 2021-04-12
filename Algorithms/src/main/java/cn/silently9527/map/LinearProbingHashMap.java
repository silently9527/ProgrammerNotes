package cn.silently9527.map;

import java.util.Objects;

public class LinearProbingHashMap<K, V> implements Map<K, V> {

    private int size;
    private int capacity;
    private K[] keys;
    private V[] values;

    public LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("Key can not null");
        }
        if (this.size > this.capacity / 2) {
            resize(2 * this.capacity);
        }
        int index;
        for (index = hash(key); this.keys[index] != null; index = (index + 1) % capacity) {
            if (this.keys[index].equals(key)) {
                this.values[index] = value;
                return;
            }
        }
        this.keys[index] = key;
        this.values[index] = value;
        size++;
    }

    private void resize(int cap) {
        LinearProbingHashMap<K, V> linearProbingHashMap = new LinearProbingHashMap<>(cap);
        for (int i = 0; i < capacity; i++) {
            linearProbingHashMap.put(keys[i], values[i]);
        }
        this.keys = linearProbingHashMap.keys;
        this.values = linearProbingHashMap.values;
        this.capacity = linearProbingHashMap.capacity;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % this.capacity;
    }

    @Override
    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("Key can not null");
        }
        int index;
        for (index = hash(key); this.keys[index] != null; index = (index + 1) % capacity) {
            if (this.keys[index].equals(key)) {
                return this.values[index];
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("Key can not null");
        }
        int index;
        for (index = hash(key); this.keys[index] != null; index = (index + 1) % capacity) {
            if (this.keys[index].equals(key)) {
                this.keys[index] = null;
                this.values[index] = null;
                break;
            }
        }

        for (index = (index + 1) % capacity; this.keys[index] != null; index = (index + 1) % capacity) {
            this.size--;
            this.put(this.keys[index], this.values[index]);
            this.keys[index] = null;
            this.values[index] = null;
        }
        this.size--;
        if (size > 0 && size < capacity / 4) {
            resize(capacity / 2);
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

}
