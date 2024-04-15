package org.lilmoon;

public class Main {
    public static void main(String[] args) {
        Philosopher p1 = new Philosopher("Socrates");
        Philosopher p2 = new Philosopher("Plato");
        Philosopher p3 = new Philosopher("Aristotle");
        Philosopher p4 = new Philosopher("Confucius");
        Philosopher p5 = new Philosopher("Avicenna");

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(p5).start();
    }

}