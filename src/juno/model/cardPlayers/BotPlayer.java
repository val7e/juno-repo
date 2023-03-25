package juno.model.cardPlayers;

/**
 * @author val7e
 */

import java.util.ArrayList;
import java.util.Random;
import juno.model.cardDeck.*;

public class BotPlayer extends Player {
    private Random rand;

    public BotPlayer(String name) {
        super(name);
        rand = new Random();
    }

    public Card playCard(Card topCard) {
        ArrayList<Card> matchingCards = new ArrayList<Card>();
        ArrayList<Card> nonWildCards = new ArrayList<Card>();

        // Check for cards that match the top card's color or value
        for (Card card : hand) {
            if (card.getColor().equals(topCard.getColor()) || card.getValue().equals(topCard.getValue())) {
                matchingCards.add(card);
            }
            if (!card.getValue().equals(Value.COLORE) && !card.getValue().equals(Value.PESCA_QUATTRO)) {
                nonWildCards.add(card);
            }
        }

        // Check for wild cards
        for (Card card : hand) {
            if (card.getValue().equals(Value.COLORE) || card.getValue().equals(Value.PESCA_QUATTRO)) {
                matchingCards.add(card);
            }
        }

        if (matchingCards.size() == 0) {
            // Draw a card if no matching cards are found
            return null;
        } else {
            // Play a random matching card, prioritizing non-wild cards first
            if (nonWildCards.size() > 0) {
                return nonWildCards.get(rand.nextInt(nonWildCards.size()));
            } else {
                return matchingCards.get(rand.nextInt(matchingCards.size()));
            }
        }
    }

    public Color chooseColor() {
        int redCount = 0;
        int yellowCount = 0;
        int greenCount = 0;
        int blueCount = 0;

        // Count the number of cards in the player's hand for each color
        for (Card card : hand) {
            if (card.getColor().equals(Color.ROSSO)) {
                redCount++;
            } else if (card.getColor().equals(Color.GIALLO)) {
                yellowCount++;
            } else if (card.getColor().equals(Color.VERDE)) {
                greenCount++;
            } else if (card.getColor().equals(Color.BLU)) {
                blueCount++;
            }
        }

        // Choose the color that the player has the most cards of
        if (redCount >= yellowCount && redCount >= greenCount && redCount >= blueCount) {
            return Color.ROSSO;
        } else if (yellowCount >= greenCount && yellowCount >= blueCount) {
            return Color.GIALLO;
        } else if (greenCount >= blueCount) {
            return Color.VERDE;
        } else {
            return Color.BLU;
        }
    }
}
