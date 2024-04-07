package org.lilmoon.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollectionIterator<T> {

    T[] array;
    private int currentIndex = 0;
    public MyCollectionIterator(T[] array) {
        this.array = array;
    }

    
    public boolean hasNext() {
        return currentIndex < array.length && array[currentIndex] != null;
    }

    
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return array[currentIndex++];
    }
}
