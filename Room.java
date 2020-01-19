
import java.util.HashMap;

public class Room {

    private String description;
    private int roomNumber;
    private HashMap<String, Door> doors;

    public Room(int number, String description) {
        this.description = description;
        this.roomNumber = number;
        doors = new HashMap<>();
    }

    public void setDoor(String number, Door door) {
        doors.put(number, door);
    }

    public int getDoors(){
        int numberOfDoors = doors.size(); 
        return numberOfDoors;
    }

    public String getDoorDescription(String number){
        Door useDoor = doors.get(number);
        String doorDesc = useDoor.getDescription();
        return doorDesc;
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
