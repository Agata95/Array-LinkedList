package com.j25.collections;

import java.util.Arrays;

public class MyArrayList {
    private final static int INITIAL_ARRAYLIST_SIZE = 10;
    private Object[] elements;
    private int size = 0;

    public MyArrayList(int initialSize) {
        this.elements = new Object[initialSize];
    }

    public MyArrayList() {
        this.elements = new Object[INITIAL_ARRAYLIST_SIZE];
    }

    // get
    public Object get(int index) {
        return elements[index];
    }

    // size
    public int size() {
        return size;
    }

    // add
    public void add(Object object) {
        if (size >= elements.length) {
            extendArray();
        }
        elements[size++] = object;
    }

    private void extendArray() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public void add(int index, Object object) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size >= elements.length) {
            // jeśli brakuje miejsca?
            extendArray(index, object);
        } else {
            for (int i = size; i >= index; i--) {
                elements[i] = elements[i - 1];
            }

            elements[index] = object;
        }
        size++;
    }

    private void extendArray(int positionToPutAt, Object object) {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = size - 1; i >= positionToPutAt; i--) {
            newElements[i + 1] = elements[i];
        }
        newElements[positionToPutAt] = object;
        for (int i = positionToPutAt - 1; i >= 0; i--) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }


    // remove
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // 5, 10, 15, 20
        //     x
        // 5, 15, 15, 20
        // 5, 15, 20, 20
        // 5, 15, 20, null
        // size --
        elements[size - 1] = null; // zerujemy miejsce ostatnie
        size--;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                builder.append(elements[i]);
                builder.append(", ");
            }

            // remove last 2 signs
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }
}
