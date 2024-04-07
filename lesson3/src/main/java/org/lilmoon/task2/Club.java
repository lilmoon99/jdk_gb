package org.lilmoon.task2;

public class Club<T extends IPerson> {
    T[] array;

    public Club(T[] array) {
        this.array = array;
    }

    public void start(){
        for (T t : array) {
            t.haveRest();
        }
    }
}
