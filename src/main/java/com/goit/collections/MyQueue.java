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
            last = new Node<>(value, null);
            first.next = last;
            return;
        }

        Node<T> oldLast = last;
        last = new Node<>(value, null);
        oldLast.next = last;
    }

    public T peek() {
        return first.item;
    }

    public T poll() {
        T result = first.item;
        first = first.next;
        size--;
        return result;
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

    /**
     * Returns Queue instance as String in next format
     * [1 -> 2 -> 3 -> ...]
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        MyQueue.Node<T> tmp = first;
        for (int i = 0; i < size; i++) {
            result.append(tmp.item);
            tmp = tmp.next;
            if (i != size - 1) {
                result.append(" -> ");
            }
        }

        return result.append(']').toString();
    }

    private static class Node<T> {
        public T item;
        public MyQueue.Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
