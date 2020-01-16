
import java.util.HashMap;

public class Room {

    private String description;
    private int roomNumber;
    private HashMap<String, String> doors;

    public Room(int number, String description) {
        this.description = description;
        this.roomNumber = number;
        doors = new HashMap<>();
    }

    public void setDoor(String number, String doorDescription) {
        doors.put(number, doorDescription);
    }

    public String getRoom() {
        String roomName = description;
        return roomName;
    }

    public int getRoomNumber() {
        int number = roomNumber;
        return number;
    }
}
