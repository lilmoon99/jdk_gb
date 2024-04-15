package org.lilmoon;

import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable{
    final int DINNER_MAX_COUNT = 2;
    final int DINNER_DURATION = 1500;
    CountDownLatch dinner = new CountDownLatch(DINNER_MAX_COUNT);

    String name;

    public Philosopher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void eat(){
        System.out.println(this.name + " начал есть.");
        try {
            Thread.sleep(DINNER_DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " покушал.");
        dinner.countDown();
    }

    private void think(){
        System.out.println(this.name + " размышляет.");
    }




    @Override
    public void run() {
        while (dinner.getCount() != 0){
            eat();
            think();
        }
    }
}
