package org.lilmoon;


public class Main {
    public static void main(String[] args) {

        Game game = new Game(5);
        game.pickDoor();
        game.revealGoats();
        game.printDoors();
        game.changePick();
        game.checkDoor();

    }
}