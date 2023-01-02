package com.goit.collections;

public class ArrayUtils {
    public static boolean isInBounds(int index, int size) {
        return index < 0 || index > size;
    }

    public static String getBoundsErrorText(int index, int size) {
        return "Index " + index + " out of bounds for length " + size;
    }
}
