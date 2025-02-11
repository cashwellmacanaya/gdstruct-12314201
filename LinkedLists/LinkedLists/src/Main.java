public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.addToFront(new Player(1, "Saitama", 999));
        playerLinkedList.addToFront(new Player(2, "Deku", 100));
        playerLinkedList.addToFront(new Player(3, "Saiki K.", 500));

        playerLinkedList.printLinkedList();

        Player searchPlayer = new Player(2, "Deku", 100);
        System.out.println("Contains Deku: " + playerLinkedList.contains(searchPlayer));
        System.out.println("Index of Deku: " + playerLinkedList.indexOf(searchPlayer));

        Player missingPlayer = new Player(4, "Naruto", 200);
        System.out.println("Contains Naruto: " + playerLinkedList.contains(missingPlayer));
        System.out.println("Index of Naruto: " + playerLinkedList.indexOf(missingPlayer));
    }
}
