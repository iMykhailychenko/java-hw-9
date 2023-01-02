package com.goit.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void testAddElement() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertEquals("[1]", list.toString());

        list.add(2);
        assertEquals("[1, 2]", list.toString());

        list.add(3);
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testRemove() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1, 2, 3]", list.toString());

        list.remove(2);
        assertEquals("[1, 2]", list.toString());

        list.remove(0);
        assertEquals("[2]", list.toString());
    }

    @Test
    public void testClear() {
        MyList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        assertEquals("[1, 2]", list.toString());

        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    public void testSize() {
        MyList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());

        list.add(5);
        assertEquals(1, list.size());

        list.add(5);
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(5);
        assertEquals((Integer) 5, list.get(0));
    }
}
