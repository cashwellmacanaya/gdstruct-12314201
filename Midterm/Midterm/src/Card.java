public class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {  // ✅ This method is missing in your code
        return name;
    }

    @Override
    public String toString() {
        return name; // Ensures cards are printed correctly in lists
    }
}
