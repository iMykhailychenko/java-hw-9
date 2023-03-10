package com.goit.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStackTest {
    @Test
    public void testPush() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        assertEquals("[1]", stack.toString());

        stack.push(2);
        assertEquals("[1 <- 2]", stack.toString());

        stack.push(3);
        assertEquals("[1 <- 2 <- 3]", stack.toString());
    }

    @Test
    public void testRemove() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("[1 <- 2 <- 3]", stack.toString());

        stack.remove(1);
        assertEquals("[1 <- 3]", stack.toString());

        stack.remove(0);
        assertEquals("[3]", stack.toString());
    }

    @Test
    public void testPeek() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals((Integer) 2, stack.peek());

        stack.push(3);
        assertEquals((Integer) 3, stack.peek());
    }

    @Test
    public void testPop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);

        assertEquals((Integer) 2, stack.pop());
        assertEquals((Integer) 1, stack.pop());
    }

    @Test
    public void testClear() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        assertEquals("[1 <- 2]", stack.toString());

        stack.clear();
        assertEquals("[]", stack.toString());
    }

    @Test
    public void testSize() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        assertEquals(1, stack.size());

        stack.push(5);
        assertEquals(2, stack.size());
    }
}
