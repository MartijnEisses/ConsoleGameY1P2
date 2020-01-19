
public class Door {

    private String description;
    private int doorNumber;
    private boolean isUnlocked;
    private int roomNumber;

    public Door(int number, int numberTwo, String desc, Boolean unlocked ){

        doorNumber = number;
        description = desc;
        isUnlocked = unlocked;
        roomNumber = numberTwo;

    }

    public void unlockDoor(){
        isUnlocked = true;
    }

    public String getDescription(){
        return description;
    }

}