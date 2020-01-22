
/*
* Martijn Eisses
* January 2020 
* Create a Console Game
*/
import java.util.*;

public class Inventory {

    public List<Item> allItems = new ArrayList<>(); // Holds all the items
    private List<Item> inventory = new ArrayList<>(); // Holds all the items of the player
    private int strength = 5; // The weigth that the player can carry
    private TextFromFile lines;

    public Inventory() {
        CreateValuableItems();
        CreateWorthlessItems();
        lines = new TextFromFile();
    }

    // Shows all the items currently in the inventory
    public void ShowInventory() {
        int weight = 0;
        System.out.println("==============Inventory==============");
        for (Item item : inventory) {
            System.out.println("  " + item.GetName() + " weighs: " + item.GetWeigth());
            weight += item.GetWeigth();
        }
        System.out.println("=====================================");
        System.out.println("  Carrying: " + weight + "kg out of " + strength + "kg");
        System.out.println("");
    }

    // Adds an item to the inventory and removes it from the allItems list when the
    // player picks it up
    // If it is too heavy the player can't pick it up
    public void AddItemToInventory(String itemName, int roomNumber) {
        Iterator<Item> it = allItems.iterator();
        Item takenItem = new Item("a", -1, 0);
        while (it.hasNext()) {
            Item item = it.next();
            // Checks if there is an item with that name and if it's in the current room
            if (item.GetName().toLowerCase().equals(itemName)) {
                if (item.GetRoomNumber() == roomNumber) {
                    takenItem = item;
                    // Gets the current weight in the inventory
                    int weight = 0;
                    for (Item invItem : inventory) {
                        weight += invItem.GetWeigth();
                    }
                    // Cant add the item because the player isn't strong enough
                    if (weight + item.GetWeigth() > strength) {
                        System.out.println(lines.GetLine(0));
                        return;
                    }
                    // Can add the item
                    else {
                        inventory.add(item);
                        ShowInventory();
                    }
                }
            }
        }
        allItems.remove(takenItem);
    }

    public void RemoveItemFromInventory(String itemName, int roomNumber) {
        Iterator<Item> it = inventory.iterator();
        Item droppedItem = new Item("a", -1, 0);
        boolean droppedAnItem = false;
        while (it.hasNext()) {
            Item item = it.next();
            if (item.GetName().toLowerCase().equals(itemName)) {
                droppedItem = item;
                item.SetRoomNumber(roomNumber);
                allItems.add(item);
                System.out.print("Dropped " + item.GetName());
                droppedAnItem = true;
            }
        }
        if (droppedAnItem) {
            inventory.remove(droppedItem);
        }
    }

    // Creates a random roomnumber for items (between 0(incl.) and 6(excl.))
    private int RandomizeRoom() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Creates all the valuable items that the player needs to finish the game
    // These are all placed in a set room to make the playthrough easier
    private void CreateValuableItems() {
        Item crowbar = new Item("Crowbar", 5, 2);
        allItems.add(crowbar);
        Item flashlight = new Item("Flashlight", 2, 1);
        allItems.add(flashlight);
        Item key = new Item("Key", 1, 4);
        allItems.add(key);
    }

    // Creates all the worthless items and places them in a random room
    private void CreateWorthlessItems() {
        Item pen = new Item("Pen", 1, RandomizeRoom());
        allItems.add(pen);
        Item hammer = new Item("Hammer", 2, RandomizeRoom());
        allItems.add(hammer);
        Item rope = new Item("Rope", 2, RandomizeRoom());
        allItems.add(rope);
        Item ducttape = new Item("Duct tape", 1, RandomizeRoom());
        allItems.add(ducttape);
        Item radio = new Item("Radio", 3, RandomizeRoom());
        allItems.add(radio);
        Item crate = new Item("Crate", 3, RandomizeRoom());
        allItems.add(crate);
    }

    public void GetItemsInRoom(int roomNumber) {
        for (Item item : allItems) {
            if (item.GetRoomNumber() == roomNumber) {
                System.out.println("-  " + item.GetName());
            }
        }
    }
}
