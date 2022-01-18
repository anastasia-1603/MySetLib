package lib;

import lib.map.IMap;
import lib.map.MyHashMap;

public class Main {
    public static void main(String[] args) {
        IMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("one", 1);
        myHashMap.put("two", 2);
        myHashMap.put("three", 3);
        System.out.println(myHashMap);

        ISet<String> set = new MyHashSet<>();
        set.add("value1");
        set.add("value2");
        set.add("value3");
        System.out.println(set);

        ISet<String> multiSet = new MyHashMultiSet<>();
        multiSet.add("value1");
        multiSet.add("value2");
        multiSet.add("value2");
        multiSet.add("value3");
        System.out.println(multiSet);

    }
}
