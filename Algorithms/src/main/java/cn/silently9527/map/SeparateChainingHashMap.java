package cn.silently9527.map;

public class SeparateChainingHashMap<K, V> implements Map<K, V> {

    private int size;
    private LinkedMap<K, V>[] table;

    public SeparateChainingHashMap(int capacity) {
        this.table = (LinkedMap<K, V>[]) new LinkedMap[capacity];
        for (int i = 0; i < capacity; i++) {
            this.table[i] = new LinkedMap<>();
        }
    }

    @Override
    public void put(K key, V value) {
        this.table[hash(key)].put(key, value);
        size++;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    @Override
    public V get(K key) {
        return this.table[hash(key)].get(key);
    }

    @Override
    public void delete(K key) {
        this.table[hash(key)].delete(key);
        size--;
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
