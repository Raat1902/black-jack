public class Card {
    private final String rank;
    private final String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int value() {
        if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) return 10;
        if (rank.equals("A")) return 11;
        return Integer.parseInt(rank);
    }

    public boolean isAce() {
        return rank.equals("A");
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}