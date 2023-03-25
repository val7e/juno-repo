/**
 * 
 */
package juno.model.cardGame;
import java.util.List;
import java.util.ArrayList;

import juno.model.cardDeck.*;
import juno.model.cardPlayers.*;
/**
 * @author val7e
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final Deck deck;
    private final List<Card> discardPile;
    private Color currentColor;
    private boolean reverseOrder;
    private boolean skipNextPlayer;
    private boolean drawTwoNextPlayer;
    private boolean drawFourNextPlayer;

    public Game(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        this.currentColor = null;
        this.reverseOrder = false;
        this.skipNextPlayer = false;
        this.drawTwoNextPlayer = false;
        this.drawFourNextPlayer = false;
    }

    public void startGame() {
        // Shuffle the deck and deal cards to each player
        deck.shuffleCards();
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCardToHand(deck.drawCard());
            }
        }

        // Place the first card on the discard pile
        Card firstCard = deck.drawCard();
        while (firstCard.getValue().equals(Value.PESCA_QUATTRO)) {
            // If the first card is an action card or a wild card, keep drawing cards until it's a number card
            deck.restartInvalidDeck(firstCard);
            firstCard = deck.drawCard();
        }
        discardPile.add(firstCard);
        currentColor = firstCard.getColor();

        // Start the game
        int currentPlayerIndex = 0;
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);

            // Check if the game is over
            if (currentPlayer.getHandSize() == 0) {
                System.out.println(currentPlayer.getNickname() + " wins!");
                break;
            }

            // Print the game state
            System.out.println("Current player: " + currentPlayer.getNickname());
            System.out.println("Current card: " + discardPile.get(discardPile.size() - 1));
            System.out.println("Current color: " + currentColor);
            System.out.println("Players:");
            for (Player player : players) {
                System.out.println(player.getNickname() + ": " + player.getHandSize() + " cards");
            }

            // Check if the next player needs to be skipped or needs to draw cards
            if (skipNextPlayer) {
                System.out.println("Skipping next player");
                skipNextPlayer = false;
                currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
                continue;
            }
            if (drawTwoNextPlayer) {
                System.out.println("Drawing two cards and skipping next player");
                currentPlayer.addCardToHand(deck.drawCard());
                currentPlayer.addCardToHand(deck.drawCard());
                drawTwoNextPlayer = false;
                skipNextPlayer = true;
                currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
                continue;
            }
            if (drawFourNextPlayer) {
                System.out.println("Drawing four cards and skipping next player");
                currentPlayer.addCardToHand(deck.drawCard());
                currentPlayer.addCardToHand(deck.drawCard());
                currentPlayer.addCardToHand(deck.drawCard());
                currentPlayer.addCardToHand(deck.drawCard());
                drawFourNextPlayer = false;
                skipNextPlayer = true;
                currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
                continue;
            }

            // Get the player's move
            Card cardToPlay = currentPlayer.playCard(discardPile.get(discardPile.size() - 1), currentColor);
            if (cardToPlay == null) {
                System.out.println(currentPlayer.getName() + " draws a card");
                currentPlayer.addCardToHand(deck.drawCard());
                continue;
            }

            //
            
            
        }
        
        
    }
    

}

