public class MainApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItem(new Item("Gun"));
        inv.addItem(new Item("Ammunition"));
        inv.addItem(new Item("Grenade"));

        System.out.println("Initial Inventory:");
        inv.display();

        System.out.println("\nTrying to combine the gun and ammunition . . . .");
        inv.combineItems("Gun", "Ammunition");

        System.out.println("\nFinal Inventory:");
        inv.display();
    }
}
