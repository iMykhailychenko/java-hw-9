package com.goit.collections;

public class MyQueue<T> implements MyCollection {
    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    public void add(T value) {
        size++;
        if (first == null) {
            first = new Node<>(value, null);
            return;
        }

        if (last == null) {
            last = new Node<>(value, first);
            return;
        }

        Node<T> oldLast = last;
        last = new Node<>(value, oldLast);
    }

    public T peek() {
        return null;
    }

    public T poll() {
        return null;
    }

    @Override
    public void clear() {
        last = null;
        first = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";
        MyQueue.Node<T> tmp = last;
        for (int i = 0; i < size; i++) {
            result += tmp.item;
            tmp = tmp.prev;
            if (i != size - 1) {
                result += " -> ";
            }
        }
        result += "]";
        return result;
    }

    private static class Node<T> {
        public T item;
        public MyQueue.Node<T> prev;

        public Node(T item, Node<T> prev) {
            this.item = item;
            this.prev = prev;
        }
    }

}
