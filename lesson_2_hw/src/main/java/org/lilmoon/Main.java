package org.lilmoon;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Backender backender = new Backender("John", 33);
        Frontender fronender = new Frontender("Bob", 22);
        Fullstack fullstackDeveloper = new Fullstack("Mike", 44);
        Developer fullstack2 = new Fullstack("Nick", 55);
        Developer frontender1 = new Frontender("Max",42);

        ArrayList<Developer> developers = new ArrayList<>();
        developers.add(backender);
        developers.add(fronender);
        developers.add(fullstackDeveloper);
        developers.add(fullstack2);
        developers.add(fronender);

        for (Developer developer : developers) {
            developer.work();
            System.out.println();
        }
    }
}