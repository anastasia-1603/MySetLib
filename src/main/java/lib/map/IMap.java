package lib.map;

public interface IMap<K, V> {
    void clear();

    V get(K key);

    boolean isEmpty();

    void put(K key, V value);

    void remove(K key);

    int size();

    boolean containsKey(K key);

    boolean containsValue(V value);
}
