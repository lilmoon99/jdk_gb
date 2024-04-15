package org.lilmoon;

import java.util.*;

public class Game {
    int doorsCount;
    List<Door> doors = new ArrayList<>(doorsCount);
    static int pick = 0;
    static int winDoorIndex = 0;

    public Game(int doorsCount) {
        this.doorsCount = doorsCount;
        initDoors();
    }

    private void initDoors(){
        for (int i = 0; i < doorsCount; i++) {
            doors.add(new Door(false));
        }
        winDoorIndex = new Random().nextInt(0,doors.size());
        doors.get(winDoorIndex).setWinningDoor(true);
    }

    public void pickDoor(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Pick door number from 1 to %d: ",doors.size());
        pick = scanner.nextInt() - 1;
    }

    public void revealGoats(){
        int selectedDoor = selectDoorToNotReveal();
//        for (int i = 0; i < doors.size(); i++) {
//
//            if (i == selectedDoor){
//                doors.get(i).setInvisible();
//            }else doors.get(i).setVisible();
//            if (doors.get(i).isWinningDoor()){
//                doors.get(i).setInvisible();
//            }
//        }
//        if (doors.get(pick).isWinningDoor()){
//            doors.get(pick).setInvisible();
//        }



        if (doors.get(pick).isWinningDoor()){
            doors.get(pick).setInvisible();
            doors.get(selectedDoor).setInvisible();
        }else {
            for (Door door : doors) {
                door.setVisible();
                if (door.isWinningDoor()) door.setInvisible();
            }
            doors.get(pick).setInvisible();
        }
    }

    public void checkDoor(){
        this.doors.get(pick).setVisible();
        System.out.println(doors.get(pick));
        if (doors.get(pick).isWinningDoor()){
            System.out.println("You win a car!");
        }else System.out.println("You win a goat :D");
    }

    public void changePick(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Do you want to change your pick?
                1 - No
                2 - Yes
                """);
        System.out.print("Your pick: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Your right. Good luck.");
                break;
            case 2:
                System.out.print("Select door: ");
                Scanner scanner1 = new Scanner(System.in);
                pick = scanner1.nextInt() - 1;
                break;
        }
    }

    public void printDoors(){
        for (Door door : doors) {
            System.out.println(door);
        }
    }

    private int selectDoorToNotReveal(){
        int select = 0;
        do {
            if (select == pick){
                select = new Random().nextInt(0,doors.size());
            }
        } while (doors.get(select).isWinningDoor());
        return select;
    }


}
