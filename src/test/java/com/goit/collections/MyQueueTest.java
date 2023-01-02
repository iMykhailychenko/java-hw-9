package com.goit.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyQueueTest {
    @Test
    public void testAddElement() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals("[3 -> 2 -> 1]", queue.toString());
    }

    @Test
    public void testClear() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(5);
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    public void testSize() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(5);
        assertEquals(1, queue.size());
    }
}
