package org.lilmoon.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Race {

    static int runnersCounter = 3;
    static CountDownLatch countDownLatch = new CountDownLatch(runnersCounter);
    static int distance = 1000;

    public static void main(String[] args) {

        Runner runner1 = new Runner("Bolt", 5, new Random().nextInt(1, 10));
        Runner runner2 = new Runner("Aynur", 100, new Random().nextInt(1, 10));
        Runner runner3 = new Runner("Elon", 25, new Random().nextInt(1, 10));
        int time = 1000;


        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        thread1.start();
        thread2.start();
        thread3.start();


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (countDownLatch.getCount() == 0) {
            try {

                System.out.println("На старт!");
                Thread.sleep(1000);
                System.out.println("Внимание!");
                Thread.sleep(1000);
                System.out.println("Марш!");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }

        selectWinner(runner1, runner2, runner3);
    }

    static void selectWinner(Runner runner1, Runner runner2, Runner runner3) {
        int time1 = distance / runner1.getSpeed();
        int time2 = distance / runner2.getSpeed();
        int time3 = distance / runner3.getSpeed();
        System.out.println(runner1.getName() + " прошел за " + time1);
        System.out.println(runner2.getName() + " прошел за " + time2);
        System.out.println(runner3.getName() + " прошел за " + time3);
    }

}
