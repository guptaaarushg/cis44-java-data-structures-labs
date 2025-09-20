public class Main {
    public static void main(String[] args) {
        DynamicArray<String> list = new DynamicArray<>();

        System.out.println("------- Adding Elements -------");
        list.add("Mustard");
        list.add("Ketchup");
        list.add("67");
        list.add("41");
        list.add("Apple");
        list.add("Pineapple");
        list.add("Grape");
        list.add("Honeydew");
        list.add("Ita Palm");
        list.add("Jackfruit");
        list.add("Kiwi");

        System.out.println("List size after adding 11 elements: " + list.size());
        System.out.println("Element at index 10: " + list.get(10));

        System.out.println("---- Removing Elements ----");
        String removed = list.remove(3);
        System.out.println("Removed element: " + removed);
        System.out.println("Element now at index 3: " + list.get(3));

        System.out.println("---- Showing All Elements ----");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        System.out.println("---- Testing Resize Again ----");
        for (int i = 0; i < 15; i++) {
            list.add("Fruit" + (i + 1));
        }
        System.out.println("List size after adding 15 more elements: " + list.size());
        System.out.println("Element at last index: " + list.get(list.size() - 1));
    }
}
