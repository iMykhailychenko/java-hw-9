package com.goit.collections;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private MyLinkedList.Node<T> first;
    private MyLinkedList.Node<T> last;

    @Override
    public boolean add(T value) {
        final Node<T> oldLast = last;
        final Node<T> newNode = new Node<>(last, value, null);
        last = newNode;

        if (oldLast == null) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        size--;
        if (index == 0) {
            first = first.next;
            first.prev = null;
            return true;
        }

        if (index == size) {
            last = last.prev;
            last.next = null;
            return true;
        }

        final Node<T> node = getNode(index);
        final Node<T> prev = node.prev;
        final Node<T> next = node.next;

        prev.next = next;
        next.prev = prev;

        return true;
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

    Node<T> getNode(int index) {
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

    @Override
    public String toString() {
        String result = "[";
        Node<T> tmp = first;
        for (int i = 0; i < size; i++) {
            result += tmp.item;
            tmp = tmp.next;
            if (i != size - 1) {
                result += " -> ";
            }
        }
        result += "]";
        return result;
    }
}
