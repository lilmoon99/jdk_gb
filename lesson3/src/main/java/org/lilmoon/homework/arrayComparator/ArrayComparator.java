package org.lilmoon.homework.arrayComparator;

import java.util.Arrays;

public class ArrayComparator {
    public static <T> boolean compareArrays(T[] array1, T[] array2){
        if (array1.length == array2.length && array1.getClass().getSimpleName().equals(array2.getClass().getSimpleName())){
            for (int i = 0; i < array1.length; i++) {
                if (!array1[i].equals(array2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
