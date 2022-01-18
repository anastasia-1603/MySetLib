package lib;

import lib.map.IMap;
import lib.map.MyHashMap;

public class MyHashSet<E> implements ISet<E> {

    protected IMap<E,Object> map;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public void add(E e) {
        map.put(e, PRESENT);
    }

    public void remove(E e) {
        map.remove(e);
    }

    public void clear() {
        map.clear();
    }

    public boolean contains(E e) {
        return map.containsKey(e);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        return ((MyHashMap<E,Object>)map).keysToString();
    }
}
