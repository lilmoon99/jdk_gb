package org.lilmoon.task3;

import java.util.Objects;

import static org.lilmoon.task3.Race.countDownLatch;

public class Runner implements Runnable{
    private String name;
    private int delay;
    private int speed;

    public Runner(String name, int delay, int speed) {
        this.name = name;
        this.delay = delay;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return delay == runner.delay && speed == runner.speed && Objects.equals(name, runner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, delay, speed);
    }


    @Override
    public String toString() {
        return "Runner{" +
                "name='" + name + '\''+
                ", speed=" + speed +
                '}';
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.getDelay());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " готов!");
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
    }
    }
