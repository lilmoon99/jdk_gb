package org.lilmoon.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker("Igor");
        Worker w2 = new Worker("Ignat");
        Idler idler1 = new Idler("Oleg");
        Idler idler2 = new Idler("Maxim");

        Workplace<IPerson> workplace = new Workplace<>(new IPerson[]{w1,w2,idler1,idler2});
        Club<IPerson> club = new Club<>(new IPerson[]{w1,w2,idler1,idler2});

        workplace.start();
        club.start();
    }
}
