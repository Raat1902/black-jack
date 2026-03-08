import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final List<Card> cards = new ArrayList<>();
    private final Random random = new Random();

    public Deck() {
        reset();
    }

    public void reset() {
        cards.clear();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards, random);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            reset();
        }
        return cards.remove(cards.size() - 1);
    }
}
