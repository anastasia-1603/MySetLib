package lib;

import lib.map.MyHashMap;

public class MyHashMultiSet<E> extends MyHashSet<E> {

    public MyHashMultiSet(){
        map = new MyHashMap<>();
    }

    @Override
    public void add(E e) {
        if (map.containsKey(e)) {
            map.put(e, (Integer) map.get(e) + 1);
            ((MyHashMap<E, Object>)map).plusSizeWith(1);
        } else {
            map.put(e, 1);
        }
    }

    @Override
    public void remove(E e) {
        if ((Integer) map.get(e) == 1) {
            map.remove(e);
        } else {
            map.put(e, (Integer) map.get(e) - 1);
            ((MyHashMap<E, Object>)map).plusSizeWith(-1);
        }
    }

    @Override
    public String toString() {
        return ((MyHashMap<E,Object>)map).keysToStringMultiMap();
    }
}
