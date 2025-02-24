import java.util.Random;
import java.util.Scanner;




public class CardGame {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.playGame();
    }
    private static final int DECK_SIZE = 30;
    private CardStack playerDeck;
    private CardStack discardPile;
    private CardStack playerHand;
    private Random random;
    private int turnCounter;

    public CardGame() {
        playerDeck = new CardStack();
        discardPile = new CardStack();
        playerHand = new CardStack();
        random = new Random();
        turnCounter = 1;
        initializeDeck();
    }

    private void initializeDeck() {
        String[] pokemonNames = {
                "Pikachu", "Charizard", "Bulbasaur", "Squirtle", "Jigglypuff",
                "Eevee", "Snorlax", "Gengar", "Mewtwo", "Lapras",
                "Gyarados", "Alakazam", "Machamp", "Dragonite", "Vaporeon",
                "Jolteon", "Flareon", "Arcanine", "Blastoise", "Venusaur",
                "Pidgeot", "Rhydon", "Nidoking", "Nidoqueen", "Kabutops",
                "Omastar", "Articuno", "Zapdos", "Moltres", "Ditto"
        };

        for (String name : pokemonNames) {
            playerDeck.push(new Card(name));
        }
    }

    private void drawCards(int x) {
        System.out.print("🎴 Drawing " + x + " card(s): ");
        for (int i = 0; i < x && !playerDeck.isEmpty(); i++) {
            Card drawnCard = playerDeck.pop();
            playerHand.push(drawnCard);
            System.out.print(drawnCard.getName() + (i < x - 1 ? ", " : ""));
        }
        System.out.println(); // Move to a new line after listing drawn cards
    }


    private void discardCards(int x) {
        System.out.println("🗑️ Discarding " + x + " card(s)...");
        for (int i = 0; i < x && !playerHand.isEmpty(); i++) {
            discardPile.push(playerHand.pop());
        }
    }

    private void retrieveCards(int x) {
        System.out.println("♻️ Retrieving " + x + " card(s) from discard pile...");
        for (int i = 0; i < x && !discardPile.isEmpty(); i++) {
            playerHand.push(discardPile.pop());
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!playerDeck.isEmpty()) {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🎲 TURN " + turnCounter);
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            int action = random.nextInt(3); // 0: Draw, 1: Discard, 2: Retrieve
            int x = random.nextInt(5) + 1; // Random 1-5

            switch (action) {
                case 0 -> drawCards(x);
                case 1 -> discardCards(x);
                case 2 -> retrieveCards(x);
            }

            displayStatus();

            // ✅ Fix: Consume leftover newline before waiting for Enter
            scanner.nextLine();  // This clears any extra input left by nextInt()

            System.out.println("\n▶ Press Enter to continue...");
            scanner.nextLine(); // Properly waits for Enter key
            turnCounter++;
        }

        System.out.println("\n🎉 GAME OVER! The player deck is empty.");
        scanner.close();
    }


    private void displayStatus() {
        System.out.println("\n📜 Player Hand: " + playerHand.toString());
        System.out.println("📦 Player Deck: " + playerDeck.size() + " cards remaining");
        System.out.println("🗃️ Discard Pile: " + discardPile.toString());
    }

}
