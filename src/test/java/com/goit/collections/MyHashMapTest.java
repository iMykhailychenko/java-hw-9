package com.goit.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyHashMapTest {
    @Test
    public void testPut() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        assertEquals("{ one:1 two:2 }", map.toString());
    }

    @Test
    public void testRemove() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        assertEquals("{ one:1 two:2 three:3 }", map.toString());

        map.remove("two");
        assertEquals("{ one:1 three:3 }", map.toString());
    }

    @Test
    public void testClear() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        map.clear();
        assertEquals("{ }", map.toString());
    }

    @Test
    public void testSize() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        assertEquals(1, map.size());

        map.put("two", 2);
        map.put("three", 3);
        assertEquals(3, map.size());

        map.remove("two");
        assertEquals(2, map.size());

        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testGet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("one", "1");
        assertEquals("1", map.get("one"));

        map.put("two", "2");
        assertEquals("2", map.get("two"));
    }

    @Test
    public void testSameKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("one", "1");
        assertEquals("1", map.get("one"));

        map.put("one", "2");
        assertEquals("2", map.get("one"));
    }
}
