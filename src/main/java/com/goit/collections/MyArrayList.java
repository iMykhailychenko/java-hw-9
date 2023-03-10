package com.goit.collections;

import java.util.*;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private int size = 0;
    private transient Object[] elementData = new Object[DEFAULT_CAPACITY];

    private void grow() {
        elementData = Arrays.copyOf(elementData, this.size * 2);
    }

    @Override
    public void add(T value) {
        if (elementData.length == size) {
            grow();
        }

        elementData[size] = value;
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        size--;
        if (size > index) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
        }
        elementData[size] = null;
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
    public T get(int index) throws IndexOutOfBoundsException {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        return (T) elementData[index];
    }

    /**
     * Returns ArrayList instance as String in next format
     * [1, 2, 3, ...]
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        for (int i = 0; i < size; i++) {
            result.append(get(i));
            if (i != size - 1) {
                result.append(", ");
            }
        }

        return result.append(']').toString();
    }
}
