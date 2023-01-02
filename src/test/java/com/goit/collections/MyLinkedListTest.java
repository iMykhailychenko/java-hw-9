package com.goit.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {
    @Test
    public void testAddElement() {
        MyList<Integer> list = new MyLinkedList<>();
        assertTrue(list.add(5));
    }

    @Test
    public void testRemove() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals((Integer) 2, list.get(0));
    }

    @Test
    public void testClear() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test
    public void testGet() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(5);
        assertEquals((Integer) 5, list.get(0));
    }

    @Test
    public void testToString() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1 -> 2 -> 3]", list.toString());
    }

    @Test
    public void testEmptyToString() {
        MyList<Integer> list = new MyLinkedList<>();
        assertEquals("[]", list.toString());
    }
}
