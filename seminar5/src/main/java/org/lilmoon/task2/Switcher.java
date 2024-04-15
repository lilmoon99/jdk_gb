package org.lilmoon.task2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Switcher {
    static Boolean switcher;
    static boolean flag;

    public static void main(String[] args) {
        switcher = true;
        flag = true;
        Thread threadA = new Thread() {
            @Override
            public void run() {
                while (flag) {
                    switcher = !switcher;
                    System.out.println("Switcher: " + switcher);
                    try {
                        Thread.sleep(666);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                int count = 20;
                while (count != 0) {
                    if (switcher) {
                        count--;
                        System.out.println("count -> " + count);
                    } else {
                        switcher = true;
                        System.out.println(switcher);
                    }
                    try {
                        Thread.sleep(333);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                flag = false;
            }
        };

        threadA.setDaemon(true);
        threadA.start();
        threadB.start();
    }
}