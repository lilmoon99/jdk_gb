package org.lilmoon.task1;

import java.io.DataInput;

public class Box<T extends Comparable<T>, V extends DataInput, K extends Number> {

    T valueT;
    V valueV;
    K valueK;

    Box(T valueT, V valueV, K valueK) {
        this.valueT = valueT;
        this.valueV = valueV;
        this.valueK = valueK;
    }

    public T getValueT() {
        return valueT;
    }

    public V getValueV() {
        return valueV;
    }

    public K getValueK() {
        return valueK;
    }

    public void printClassName() {
        System.out.printf("Value T: %s, Value V:%s, Value K: %s",
                this.valueT.getClass().getSimpleName(),
                this.valueV.getClass().getSimpleName(),
                this.valueK.getClass().getSimpleName());
    }
}
