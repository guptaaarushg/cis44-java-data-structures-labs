public class ItineraryApp {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        Position<String> paris = itinerary.addLast("Eiffel Tower");
        itinerary.addLast("Louvre");
        Position<String> rome = itinerary.addLast("Roman Colosseum");

        itinerary.addAfter(paris, "Statue of Liberty");
        itinerary.addBefore(rome, "Taj Mahal");

        System.out.println("Final Itinerary:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}
