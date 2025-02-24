import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card card) {
        stack.push(card);
    }

    public Card pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        if (stack.isEmpty()) return "Empty";

        StringBuilder sb = new StringBuilder("[");
        for (Card card : stack) {
            sb.append(card.getName()).append(", ");
        }

        // Remove the last comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
