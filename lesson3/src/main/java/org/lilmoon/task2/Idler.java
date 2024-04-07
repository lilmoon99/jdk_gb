package org.lilmoon.task2;

public class Idler implements IPerson{
    private String name;

    public Idler(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.printf("%s, Can't do any work!\n", this.name);
    }

    @Override
    public void haveRest() {
        System.out.printf("%s, Resting good!\n", this.name);
    }
}
