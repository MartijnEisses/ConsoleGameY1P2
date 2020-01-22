
public class Door {

    private String description;
    private int doorNumber;
    private boolean isUnlocked;
    private int roomNumber;

    public Door(int doorNumber, int roomNumber, String desc, Boolean unlocked) {
        this.doorNumber = doorNumber;
        description = desc;
        isUnlocked = unlocked;
        this.roomNumber = roomNumber;
    }

    public void UnlockDoor() {
        isUnlocked = true;
    }

    public boolean IsUnlocked() {
        return isUnlocked;
    }

    public String GetDescription() {
        return description;
    }

    public int GetRoomNumber() {
        return roomNumber;
    }

}