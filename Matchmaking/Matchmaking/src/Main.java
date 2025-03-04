import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int gameCount = 0;
        int playerId = 1;

        while (gameCount < 10) {
            int newPlayers = rand.nextInt(7) + 1;
            System.out.println("Adding " + newPlayers + " players to the queue ");

            for (int i = 0; i < newPlayers; i++) {
                queue.add("Player" + playerId++);
            }

            System.out.println("Current queue " + queue);
            System.out.println("Press Enter to continue ");
            scanner.nextLine();

            if (queue.size() >= 5) {
                System.out.println("Startig a new game with ");
                for (int i = 0; i < 5; i++){
                    System.out.println(" - " + queue.poll());
                }
                gameCount++;
                System.out.println("Game " + gameCount + " Started");
            } else {
                System.out.println("Waiting for other players to join... ");
            }
        }
        System.out.println("10 games have been created. ");
        scanner.close();
    }
}
