package org.lilmoon.homework.calculator;

public class Calculator {
    public static <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer){
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        }else if(num1 instanceof Double || num2 instanceof Double){
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        }else throw new IllegalArgumentException("Not supported type!");
    }

    public static <T extends Number> T substract(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer){
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        }else if(num1 instanceof Double || num2 instanceof Double){
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        }else throw new IllegalArgumentException("Not supported type!");
    }
    public static <T extends Number> T multiply(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer){
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        }else if(num1 instanceof Double || num2 instanceof Double){
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        }else throw new IllegalArgumentException("Not supported type!");
    }
    public static <T extends Number> T divide(T num1, T num2) {
        try {
            boolean isHasMantissa = num1.doubleValue() % num2.doubleValue() != 0;
            if (isHasMantissa){
                return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
            }else return (T) Integer.valueOf(num1.intValue() / num2.intValue());

        }catch (ArithmeticException e){
            System.out.println("Division by zero!!!");
        }
        return num2;
    }
}
