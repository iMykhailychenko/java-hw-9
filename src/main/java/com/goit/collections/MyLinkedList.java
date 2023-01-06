package com.goit.collections;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private MyLinkedList.Node<T> first;
    private MyLinkedList.Node<T> last;

    @Override
    public void add(T value) {
        final Node<T> oldLast = last;
        final Node<T> newNode = new Node<>(last, value, null);
        last = newNode;

        if (oldLast == null) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        size--;
        if (index == 0) {
            first = first.next;
            first.prev = null;
            return;
        }

        if (index == size) {
            last = last.prev;
            last.next = null;
            return;
        }

        final Node<T> node = getNode(index);
        final Node<T> prev = node.prev;
        final Node<T> next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).item;
    }

    /**
     * Utility method. Finds a Node by index and returns it.
     * Similar to the get method, but it returns the entire Node instead of the value
     * @param index int
     * @return Node<T>
     */
    private Node<T> getNode(int index) {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        Node<T> item = first;
        for (int i = 0; i < size; i++) {
            if (i == index) break;
            item = item.next;
        }

        return item;
    }

    private static class Node<T> {
        public T item;
        public  Node<T> next;
        public Node<T> prev;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Returns LinkedList instance as String in next format
     * [1 -> 2 -> 3 -> ...]
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        for (int i = 0; i < size; i++) {
            result.append(get(i));
            if (i != size - 1) {
                result.append(" -> ");
            }
        }

        return result.append(']').toString();
    }
}
