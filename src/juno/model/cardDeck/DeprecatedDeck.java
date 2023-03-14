package juno.model.cardDeck;

import java.util.ArrayList;

public class DeprecatedDeck {
	
	private ArrayList<Card> deck;
	private int totalCards = 108;
	
	public DeprecatedDeck() {
		this.deck = new ArrayList<Card>(totalCards);
		this.addNumberCards();
		this.addActionCards();
		this.addJollyCards();
//		System.out.println(this.deck);
	}
	
	/**
	 * This method adds the numbered cards to the deck, specifically:
	 *    one '0' card for deck
	 *    two cards for each of the rest of the numbers
	 *    for a total of 68 numbered cards
	 */
	private void addNumberCards() {
		
		for (int i = 0; i < Color.values().length; i++) {
			for (int j = 0; j < Number.values().length; j++) {
				deck.add(new CardNumber(Color.values()[i], Number.values()[j]));
				if (j > 0) {
					deck.add(new CardNumber(Color.values()[i], Number.values()[j]));
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
		for (int i = 0; i < Color.values().length; i++) {
			for (int j = 0; j < Action.values().length; j++) {
				deck.add(new CardAction(Color.values()[i], Action.values()[j]));
				deck.add(new CardAction(Color.values()[i], Action.values()[j]));
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
		for (int i = 0; i < Jolly.values().length; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new CardJolly(Jolly.values()[i]));
			}
		}
	}
}
