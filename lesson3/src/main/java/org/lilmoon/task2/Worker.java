package org.lilmoon.task2;

public class Worker implements IPerson{

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.printf("%s, Working good!\n",this.name);
    }

    @Override
    public void haveRest() {
        System.out.printf("%s, Can't rest if enemies near!\n",this.name);
    }

}
