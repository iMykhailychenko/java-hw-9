package com.goit.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyQueueTest {
    @Test
    public void testAddElement() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        assertEquals("[1]", queue.toString());

        queue.add(2);
        assertEquals("[1 -> 2]", queue.toString());

        queue.add(3);
        assertEquals("[1 -> 2 -> 3]", queue.toString());
    }

    @Test
    public void testClear() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        assertEquals("[1 -> 2]", queue.toString());

        queue.clear();
        assertEquals("[]", queue.toString());
    }

    @Test
    public void testSize() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(5);
        assertEquals(1, queue.size());

        queue.add(5);
        assertEquals(2, queue.size());
    }

    @Test
    public void testPeek() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);

        assertEquals((Integer) 1, queue.peek());
    }

    @Test
    public void testPoll() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals((Integer) 1, queue.poll());
        assertEquals("[2 -> 3]", queue.toString());
    }
}
