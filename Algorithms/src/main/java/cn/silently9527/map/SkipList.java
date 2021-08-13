package cn.silently9527.map;

public class SkipList<K extends Comparable<K>, V> implements Map<K, V> {
    private Entries head;
    private Entries tail;
    private int maxLevel;


    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    private Entries find(K key) {
        int level = maxLevel;
        Entries entries = head;
        while (level >= 0) {
            Entry entry = entries.entries[level];
            if (entry.next.key.compareTo(key) > 0) {

            } else if (entry.next.key.compareTo(key) == 0) {

            } else {

            }
        }
        return null;
    }

    class Entries {
        public Entry[] entries;
        public int level;
    }

    class Entry {
        public K key;
        public V value;
        public Entry pre;
        public Entry next;
        private Entries entries;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
