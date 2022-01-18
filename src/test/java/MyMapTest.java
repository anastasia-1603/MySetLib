import lib.map.IMap;
import lib.map.MyHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void testPutting() {
        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.put("key1", "newvalue1");
        assertEquals("newvalue1", map.get("key1"));
    }

    @Test
    public void testRemove() {

        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key1");

        assertEquals(2, map.size());
    }

    @Test
    public void testRemoveWrongKey() {
        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key15");

        assertEquals(3, map.size());
    }

    @Test
    public void testRetrieveValue() {

        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));

        assertNull(map.get("key4"));
    }

    @Test
    public void testEmpty() {

        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testContainsKey() {

        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key23"));
    }


    @Test
    public void testContainsValue() {
        IMap<String, String> map = new MyHashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertTrue(map.containsValue("value2"));
        assertFalse(map.containsValue("value23"));
    }

    @Test
    public void testResize() {
        MyHashMap<String, String> map = new MyHashMap<>();

        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value1");
        map.put("5", "value2");
        map.put("6", "value3");
        map.put("7", "value1");
        map.put("8", "value2");
        map.put("9", "value3");
        map.put("10", "value1");
        map.put("11", "value2");
        map.put("12", "value3");
        map.put("13", "value1");
        map.put("14", "value2");
        map.put("15", "value3");
        map.put("16", "value1");
        map.put("17", "value2");
        map.put("18", "value3");

        assertEquals(18, map.size());
        assertEquals(32, map.getTableSize());
    }
}
