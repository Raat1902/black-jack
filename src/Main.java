import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!\n");

        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();

        player.add(deck.draw());
        dealer.add(deck.draw());
        player.add(deck.draw());
        dealer.add(deck.draw());

        player.print("Player");
        System.out.println("Dealer shows: " + dealer.get(0));
        System.out.println();

        while (true) {
            String choice = readChoice(scanner, "Hit or Stand? ");
            if (choice == null) {
                System.out.println("\nGoodbye!");
                return;
            }

            if (choice.equals("hit")) {
                player.add(deck.draw());
                player.print("Player");

                if (player.value() > 21) {
                    System.out.println("Bust! Dealer wins.");
                    return;
                }
            } else if (choice.equals("stand")) {
                break;
            } else {
                System.out.println("Please type: hit or stand");
            }
        }

        while (dealer.value() < 17) {
            dealer.add(deck.draw());
        }

        System.out.println("\nFinal Hands:");
        player.print("Player");
        dealer.print("Dealer");

        int playerScore = player.value();
        int dealerScore = dealer.value();

        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore == dealerScore) {
            System.out.println("Push! It's a tie.");
        } else {
            System.out.println("Dealer wins.");
        }
    }

    private static String readChoice(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) return null;
        return scanner.nextLine().trim().toLowerCase(Locale.ROOT);
    }
}