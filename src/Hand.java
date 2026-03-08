import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public List<Card> all() {
        return cards;
    }

    public int value() {
        int total = 0;
        int aceCount = 0;

        for (Card c : cards) {
            total += c.value();
            if (c.isAce()) aceCount++;
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public void print(String owner) {
        System.out.println(owner + "'s hand:");
        for (Card c : cards) {
            System.out.println(" - " + c);
        }
        System.out.println("Total: " + value());
        System.out.println();
    }
}