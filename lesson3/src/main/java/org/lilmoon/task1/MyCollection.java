package org.lilmoon.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MyCollection<T> {
    Object[] array;
    private int size = 0;
    private int capacity = 10;
    float loadFactor = 0.75f;
    private int currentIndex = 0;


    MyCollection() {
        array = new Object[capacity];
    }

    public void add(T element) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        for (Object o : array) {
            if (o != null) {
                returnValue.append(", ").append(o);
            }
        }
        return returnValue.toString();
    }

    public void deleteElement(T element) {
        if (size == 0) System.out.println("Array is empty");
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
                size--;
                return;
            }
        }

    }

    public T[] getCollection(){
        T[] tempArray = (T[]) new Object[size];
        System.arraycopy(array,0,tempArray,0,size);
        return tempArray;
    }

    public boolean hasNext() {
        if (array[currentIndex] != null && currentIndex < size) {
            return true;
        }
        return false;
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return (T) array[currentIndex++];
    }
}



