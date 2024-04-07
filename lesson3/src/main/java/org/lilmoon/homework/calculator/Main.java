package org.lilmoon.homework.calculator;

public class Main {
    public static void main(String[] args) {
        sumTest();
        subtractTest();
        multiplyTest();
        divisionTest();
    }

    private static void subtractTest() {
        System.out.println("Subtraction test");
        System.out.println(Calculator.substract(4, 10));
        System.out.println(Calculator.substract(5.2, 4.5));
        System.out.println(Calculator.substract(5, 2.5));
        System.out.println();
    }

    private static void sumTest() {
        System.out.println("Summation Test");
        System.out.println(Calculator.sum(1, 4.2));
        System.out.println(Calculator.sum(5, 3));
        System.out.println();
    }

    private static void multiplyTest() {
        System.out.println("Multiplication test");
        System.out.println(Calculator.multiply(5, 13));
        System.out.println(Calculator.multiply(4, 5.5));
        System.out.println();
    }

    private static void divisionTest() {
        System.out.println("Division test");
        System.out.println(Calculator.divide(4, 5));
        System.out.println(Calculator.divide(100, 4));
        System.out.println(Calculator.divide(43,0));
        System.out.println();
    }
}
