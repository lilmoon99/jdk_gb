package org.lilmoon.homework.arrayComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        runTest();

    }

    private static void runTest() {
        Integer[] array1 = new Integer[]{1,2,3,4};
        Integer[] array2 = new Integer[]{1,2,3,4};
        Integer[] array3 = new Integer[]{3,2,5,1};
        Integer[] array4 = new Integer[]{1,2,3,4,5};

        String[] strings1 = {"Word", "Some", "Generate", "Next"};
        String[] strings2 = {"Word", "Some", "Generate"};
        String[] strings3 = {"Word", "Some", "Generate"};


        testArrayComparator(array1,array2);
        testArrayComparator(array1,array3);
        testArrayComparator(array1,array4);
        testArrayComparator(array3,array4);

        testArrayComparator(strings1,strings2);
        testArrayComparator(strings3,strings2);
    }

    private static  <T> void testArrayComparator(T[] array1,T[] array2){
        System.out.println("Array 1:" + Arrays.toString(array1));
        System.out.println("Array 2:" + Arrays.toString(array2));
        System.out.println("Is equal: " + ArrayComparator.compareArrays(array1,array2));
        System.out.println("___________________________________________");
    }
}
