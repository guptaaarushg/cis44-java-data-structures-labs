import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory: ");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void combineItems(String name1, String name2) {
        Item firstItem = null;
        Item secondItem = null;

        Iterator<Item> it = items.iterator();

        while (it.hasNext()) {
            Item current = it.next();

            if (firstItem == null && current.getName().equalsIgnoreCase(name1)) {
                firstItem = current;
                it.remove();
            } else if (secondItem == null && current.getName().equalsIgnoreCase(name2)) {
                secondItem = current;
                it.remove();
            }

            if (firstItem != null && secondItem != null) {
                break;
            }
        }

        if (firstItem != null && secondItem != null) {
            String combinedName = firstItem.getName() + " + " + secondItem.getName();
            Item newItem = new Item("Shooting Gun (" + combinedName + ")");
            items.add(newItem);
            System.out.println("Combined " + firstItem + " and " + secondItem + " into " + newItem + "!");
        } else {
            System.out.println("Could not combine. One or both items not found.");
            if (firstItem != null) {
                items.add(firstItem);
            }
            if (secondItem != null) {
                items.add(secondItem);
            }
        }
    }
}
