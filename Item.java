public class Item {
    private String name;
    private Integer weight;
    private Integer roomNumber;

    public Item(String name, Integer weight, Integer roomNumber) {

        this.name = name;
        this.weight = weight;
        this.roomNumber = roomNumber;
    }

    public String GetName() {
        return name;
    }

    public Integer GetWeigth() {
        return weight;
    }

    public Integer GetRoomNumber() {
        return roomNumber;
    }

    public void SetRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

}