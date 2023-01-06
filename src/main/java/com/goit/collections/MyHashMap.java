package com.goit.collections;

public class MyHashMap<K, V> implements MyCollection {
    private static final int DEFAULT_CAPACITY = 16;

    private int size = 0;
    /**
     * Implement next data structure:
     * Array with 16 elements
     * [] -> null
     * [] -> Node -> Node -> null
     * [] -> Node -> null
     * ...
     */
    private Object[] elementData = new Object[DEFAULT_CAPACITY];

    /**
     * Returns a number that is less than the length of elementData. The number will be used as an index
     * @param key K
     * @return int
     */
    private int getIndex(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }

    /**
     * To simplify the casting of types
     * @param index int
     * @return Node<K, V>
     */
    private Node<K, V> getNode(int index) {
        return (Node<K, V>) elementData[index];
    }

    /**
     * Adds a key + value pair to HashMap. If pass an existing key, the value will be overwritten
     * @param key K
     * @param value V
     */
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


    /**
     * Deletes an element by key. Does nothing if the element is not found
     * @param key K
     */
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = getNode(index);

        if (node == null) {
            return;
        }

        if (node.key.equals(key)) {
            elementData[index] = node.next;
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

    /**
     * Returns HashMap instance as String in next format
     * { key:value key2:value2 ... }
     * @return String
     */
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

    /**
     * A linked list is stored in the elementData array in case the hash function returns the same index for different keys.
     * This class will help to create a linked list.
     * @param <K>
     * @param <V>
     */
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
