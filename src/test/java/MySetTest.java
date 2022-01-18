import lib.ISet;
import lib.MyHashSet;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    @Test
    public void testInitialization() {
        ISet<String> set = new MyHashSet<>();
        assertEquals(0, set.size());
    }

    @Test
    public void testAdd() {
        ISet<String> set = new MyHashSet<>();
        set.add("a");
        assertEquals(1, set.size());
        assertTrue(set.contains("a"));
        assertFalse(set.contains("b"));

        set.add("b");
        assertEquals(2, set.size());
        assertTrue(set.contains("a"));
        assertTrue(set.contains("b"));
    }

    @Test
    public void testCollision() {
        ISet<String> set = new MyHashSet<>();
        set.add("abc");
        assertEquals(1, set.size());
        assertTrue(set.contains("abc"));
        assertFalse(set.contains("abcd"));

        set.add("abcd");
        assertEquals(2, set.size());
        assertTrue(set.contains("abc"));
        assertTrue(set.contains("abcd"));

        set.remove("abc");
        assertFalse(set.contains("abc"));
    }

    @Test
    public void testRemove() {
        ISet<String> set = new MyHashSet<>();
        set.add("value");
        assertTrue(set.contains("value"));

        set.remove("value");
        assertEquals(0, set.size());
        assertFalse(set.contains("value"));
    }

    @Test
    public void testContainsWrong() {
        ISet<String> set = new MyHashSet<>();
        set.add("value1");
        set.add("value2");
        assertTrue(set.contains("value1"));
        assertFalse(set.contains("value5"));
    }

    @Test
    public void testEmpty() {
        ISet<String> set = new MyHashSet<>();
        assertEquals(0, set.size());
        set.add("value1");
        set.add("value2");
        assertEquals(2, set.size());
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }
}
