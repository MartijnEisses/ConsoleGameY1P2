
import java.util.HashMap;

public class Room {

    private String description;
    private int roomNumber;
    private HashMap<Integer, Door> doors;
    private int[] roomLines;

    public Room(int number, String description, int[] roomLines) {
        this.description = description;
        this.roomNumber = number;
        this.roomLines = roomLines;
        doors = new HashMap<>();
    }

    public void SetDoor(int number, Door door) {
        doors.put(number, door);
    }

    public int GetDoors() {
        int numberOfDoors = doors.size();
        return numberOfDoors;
    }

    public void SetRoomDescription(String i) {
        description = i;
    }

    public boolean checkDoorunlock(int doorNumber) {
        Door thisDoor = doors.get(doorNumber);
        boolean unlocked = thisDoor.IsUnlocked();
        return unlocked;
    }

    public String GetDoorDescription(int number) {
        if (doors.containsKey(number)) {
            return "Door " + number + ": " + doors.get(number).GetDescription();
        } else {
            return "That door doesn't exist";
        }
    }

    public int[] GetRoomLines() {
        return roomLines;
    }

    public String GetRoom() {
        String roomName = description;
        return roomName;
    }

    public int GetRoomNumber() {
        int number = roomNumber;
        return number;
    }

    public int GetRoomNumberByDoor(int number) {
        Door useDoor = doors.get(number);
        int roomNumberByDoor = useDoor.GetRoomNumber();
        return roomNumberByDoor;
    }
}