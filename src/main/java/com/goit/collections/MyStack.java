package com.goit.collections;

public class MyStack<T> implements MyCollection {
    private MyList<T> elementData = new MyArrayList<>();

    public void push(T value) {
        elementData.add(value);
    }

    public void remove(int index) {
        elementData.remove(index);
    }

    public T peek() {
        return elementData.get(elementData.size() - 1);
    }

    public T pop() {
        int lastIndex = elementData.size() - 1;
        T result = elementData.get(lastIndex);
        elementData.remove(lastIndex);

        return result;
    }

    @Override
    public void clear() {
        elementData = new MyArrayList<>();
    }

    @Override
    public int size() {
        return elementData.size();
    }

    /**
     * Returns Stack instance as String in next format
     * [1 <- 2 <- 3 <- ...]
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        for (int i = 0; i < size(); i++) {
            result.append(elementData.get(i));

            if (i != size() - 1) {
                result.append(" <- ");
            }
        }

        return result.append(']').toString();
    }
}
