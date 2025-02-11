import java.util.NoSuchElementException;

public class PlayerLinkedList {

    private PlayerNode head;
    private int size;

    public void addToFront(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNextPlayerNode(head);
        head = newNode;
        size++;
    }

    public Player removeFromFront() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }
        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayerNode();
        size--;
        return removedPlayer;
    }

    public int size() {
        return size;
    }

    public void printLinkedList() {
        System.out.print("(Head) -> ");
        PlayerNode current = head;

        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayerNode();
        }
        System.out.println("NULL");
    }


    public boolean contains(Player player) {
        return indexOf(player) != -1;
    }


    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayerNode();
            index++;
        }
        return -1;
    }
}
