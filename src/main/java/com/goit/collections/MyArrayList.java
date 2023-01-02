package com.goit.collections;

import java.util.*;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private int size = 0;
    private transient Object[] elementData;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.elementData = new Object[capacity];
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, this.size + DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(T value) {
        if (elementData.length == size) {
            grow();
        }

        elementData[size] = value;
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        if (ArrayUtils.isInBounds(index, size)) {
            throw new IndexOutOfBoundsException(ArrayUtils.getBoundsErrorText(index, size));
        }

        System.arraycopy(elementData, index + 1, elementData, index, size);
        size--;
        return false;
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

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += elementData[i];
            if (i != size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
