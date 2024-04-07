package org.lilmoon.task2;

public class Workplace <T extends IPerson>{
    T[] array;

    public Workplace(T[] array) {
        this.array = array;
    }

    public void start(){
        for (T t : array) {
            t.doWork();
        }
    }
}
