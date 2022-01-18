package lib.map;

import java.util.Arrays;

public class MyHashMap<K, V> implements IMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 8;

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final int getHash() {
            return hash;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final void setValue(V newValue) {
            value = newValue;
        }
    }

    private int size;
    private Node<K, V>[] table = new Node[DEFAULT_INITIAL_CAPACITY];

    public MyHashMap() {
    }

    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() & (table.length - 1);
    }

    public void clear() {
        if (table != null && size > 0) {
            size = 0;
            Arrays.fill(table, null);
        }
    }

    public V get(K key) {
        Node<K, V> node;
        V value = null;
        int hash = hash(key);
        if (table != null && table.length > 0 && (node = table[hash]) != null) {
            if (node.getHash() == hash && key.equals(node.getKey())) {
                value = node.getValue();
            } else {
                for (int i = hash; i < table.length; i++) {
                    if (table[i].getKey().equals(key)) {
                        value = node.getValue();
                        break;
                    }
                }
            }
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        if (table[hash] != null) {
            if (table[hash].getKey().equals(key)) {
                table[hash].setValue(value);
            } else {
                resize();
                size++;
                for (int i = hash; i < table.length; i++) {
                    if (table[i] == null) {
                        table[i] = new Node<>(hash, key, value);
                    }
                }
            }
        } else {
            resize();
            size++;
            table[hash] = new Node<>(hash(key), key, value);
        }
    }

    private void resize() {
        if (size == table.length) {
            int newSize = table.length * 2;
            table = Arrays.copyOf(table, newSize);
        }
    }

    @Override
    public void remove(K key) {
        Node<K, V> node;
        int hash = hash(key);
        if (table != null && table.length > 0 && (node = table[hash]) != null) {
            if (node.getHash() == hash && key.equals(node.getKey())) {
                table[hash] = null;
                size--;
                moveArray(hash);
            } else {
                for (int i = hash; i < table.length; i++) {
                    if (table[i] != null && table[i].getKey().equals(key)) {
                        table[i] = null;
                        size--;
                        moveArray(i);
                    }
                }
            }
        }
    }

    private void moveArray(int start) {
        if (size - start >= 0) {
            System.arraycopy(table, start + 1, table, start, size - start);
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void plusSizeWith(int delta) {
        size += delta;
    }

    public int getTableSize() {
        return table.length;
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> node;
        int hash = hash(key);
        if (table != null && table.length > 0 &&
                (node = table[hash]) != null) {
            if (node.getHash() == hash && key.equals(node.getKey())) {
                return true;
            } else {
                for (int i = hash; i < table.length; i++) {
                    if (table[i] != null && table[i].getKey().equals(key) && node.getHash() == hash) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        if (table != null && size > 0) {
            for (Node<K, V> e: table) {
                if (e != null && e.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int currSize = 0;
        for (Node<K, V> node: table) {
            if (node != null) {
                currSize++;
                s.append(node);
                if (currSize != size) {
                    s.append(", ");
                }
            }
        }
        return s.toString();
    }

    public String keysToString() {
        StringBuilder s = new StringBuilder();
        int currSize = 0;
        for (Node<K, V> node: table) {
            if (node != null) {
                currSize++;
                s.append(node.getKey());
                if (currSize != size) {
                    s.append(", ");
                }
            }
        }
        return s.toString();
    }

    public String keysToStringMultiMap() {
        StringBuilder s = new StringBuilder();
        int currSize = 0;
        for (Node<K, V> node: table) {
            if (node != null) {
                for (int i = 0; i < (Integer) node.getValue(); i++)
                {
                    currSize++;
                    s.append(node.getKey());
                    if (currSize != size) {
                        s.append(", ");
                    }
                }
            }
        }
        return s.toString();
    }
}
