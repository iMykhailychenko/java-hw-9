package com.goit.collections;

public interface MyList<T> extends MyCollection {
    boolean add(T value);

    boolean remove(int index);

    T get(int index);
}
