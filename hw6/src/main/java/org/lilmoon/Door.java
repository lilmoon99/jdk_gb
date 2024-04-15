package org.lilmoon;

public class Door {
    private boolean isWinningDoor;
    private boolean isRevealed = false;

    public Door(boolean isWinningDoor) {
        this.isWinningDoor = isWinningDoor;
    }

    public void setWinningDoor(boolean winningDoor) {
        isWinningDoor = winningDoor;
    }

    public boolean isWinningDoor() {
        return isWinningDoor;
    }

    public void setVisible(){
        this.isRevealed = true;
    }

    public void setInvisible(){
        this.isRevealed = false;
    }

    @Override
    public String toString() {
        if (isRevealed) {
            if (isWinningDoor){
                return "Door with car!";
            }else return "Goat!";
        } else return "Door not revealed!";
    }
}
