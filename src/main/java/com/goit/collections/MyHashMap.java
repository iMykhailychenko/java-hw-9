package com.goit.collections;

import java.util.Arrays;

public class MyHashMap<K, V> implements MyCollection {
    private static final int DEFAULT_CAPACITY = 16;

    private int size = 0;
    private Object[] elementData = new Object[DEFAULT_CAPACITY];

    private int getIndex(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }

    private Node<K, V> getNode(int index) {
        return (Node<K, V>) elementData[index];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = getNode(index);

        if (node == null) {
            elementData[index] = new Node<>(key, value, null);
            size++;
            return;
        }

        if (node.key.equals(key)) {
            node.value = value;
            return;
        }


        while (true) {
            // for last element
            if (node.next == null) {
                size++;
                node.next = new Node<>(key, value, null);
                break;
            }

            if (node.next.key.equals(key)) {
                node.next.value = value;
                break;
            }

            node = node.next;
        }
    }


    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = getNode(index);

        if (node == null) {
            return;
        }

        if (node.key.equals(key)) {
            Node<K, V> newNode = (Node<K, V>) elementData[index];
            elementData[index] = newNode.next;
            size--;
            return;
        }

        while (true) {
            // for last element
            if (node.next == null) {
                break;
            }

            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                break;
            }

            node = node.next;
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = getNode(index);

        if (node.key.equals(key)) {
            return node.value;
        }

        while (true) {
            // for last element
            if (node.next == null) {
                break;
            }

            if (node.next.key.equals(key)) {
                break;
            }

            node = node.next;
        }

        return node.next == null ? null : node.next.value;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{ ");

        for (Object element: elementData) {
            if (element == null) {
                continue;
            }

            Node<K, V> node = (Node<K, V>) element;
            while (true) {
                if (node == null) {
                    break;
                }

                result.append(node.key).append(":").append(node.value).append(' ');
                node = node.next;
            }
        }

        return result.append('}').toString();
    }

    private static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
