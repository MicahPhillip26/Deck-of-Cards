import java.util.Random;
import java.util.Stack;

public class DeckOfCards {
    public static void main(String[] args) {
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};

        Card[] deck = new Card[52];
        int index = 0;

        // Populate the deck with cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(rank, suit);
            }
        }

        Stack<Card> stack = new Stack<>();
        Random random = new Random();
        boolean[] picked = new boolean[52];

        // Pick 5 random cards and push them onto the stack
        for (int i = 0; i < 5; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(52);
            } while (picked[randomIndex]);

            picked[randomIndex] = true;
            stack.push(deck[randomIndex]);
        }

        // Pop and reveal the cards from the stack
        System.out.println("Cards drawn:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

