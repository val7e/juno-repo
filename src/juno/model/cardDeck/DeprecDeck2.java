/**
 * 
 */
package juno.model.cardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * This class represents a deck of cards, which is always created in the same way.
 * @author val7e
 *
 */
public class DeprecDeck2 {
	private Stack<DeprecCard> deck;
	private int totalCards = 108; //mi serve effettivamente?? si per checkare se sta finendo
	
	/**
	 * Constructor method that invokes other methods to add every type of card to the deck.
	 */
	public DeprecDeck2() {
		this.deck = new Stack<DeprecCard>(); //non serve dichiarare la lunghezza
		this.addNumberCards();
		this.addActionCards();
		this.addJollyCards();
		this.shuffleCards();
	}
	
	/**
	 * This method adds numbered cards to the deck, specifically:
	 *    one '0' card for deck
	 *    two cards for each one of the rest of the numbers
	 *    for a total of 68 numbered cards
	 */
	private void addNumberCards() {
		for (Color c : Color.values()) {
			for (DeprecNumber n : DeprecNumber.values()) {
				deck.add(new DeprecCardNumber(c,n));
				if (n != DeprecNumber.ZERO) {
					deck.add(new DeprecCardNumber(c,n));
				}
			}
		}
	}
	
	/**
	 * This method adds the action cards to the deck, specifically:
	 *  	two 'SALTO' cards for each color, for a total of 8 cards,
	 *  	two 'INVERTI' cards for each color, for a total of 8 cards,
	 *  	two 'PESCADUE' cards for each color, for a total of 8 cards,
	 *  	for a total of 24 action cards
	 */
	private void addActionCards() {
		for (Color c : Color.values()) {
			for (DeprecAction a : DeprecAction.values()) {
				deck.add(new DeprecCardAction(c,a));
				deck.add(new DeprecCardAction(c,a));
			}
		}
	}
	
	/**
	 * This method adds the jolly cards to the deck, specifically:
	 *    four 'JOLLYCOLORE',
	 *    four 'JOLLYPESCAQUATTRO',
	 *    for a total of 8 jolly cards
	 */
	private void addJollyCards() {
		for (DeprecJolly j : DeprecJolly.values()) {
			for (int i = 0; i < 4; i++) {
				deck.add(new DeprecCardJolly(j));
			}
		}
	}
	
	/**
	 * This the getter method for the deck.
	 * @return deck
	 */
	public Stack<DeprecCard> getDeck() {
		return deck;
	}
	
	/**
	 * This method mixes the deck.
	 */
	public void shuffleCards() {
		Collections.shuffle(deck);
	}
	
	/**
	 * This method allows each player to draw a card; it is also used to turn the first card
	 * at the beginning of each game, since it is exactly the same action.
	 * ???? forse questo cambia quando implemento la view!!!
	 * @return
	 */
	public DeprecCard drawCard() {
		return deck.pop();
	}
	
	/**
	 * This method is invoked if the first card drawn from the deck is invalid,
	 * so it restarts the deck.
	 * @param card
	 */
	public void restartInvalidDeck(DeprecCard card) {
		deck.add(card);
		shuffleCards();
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public ArrayList<DeprecCard> getPlayerHand() {
		ArrayList<DeprecCard> playerHand = new ArrayList<DeprecCard>();
		for (int i = 0; i < 7; i++) {
			playerHand.add(drawCard());
		} return playerHand;
	}
	
	public boolean checkInvalidInitCard(DeprecCard card) {
		if (card.getType().equals("Jolly") && card.getJolly()==DeprecJolly.JOLLYPESCAQUATTRO) {
			System.out.println("Can't start game with card " + card.getJolly());
			return true;
		} else return false;
	}
}
