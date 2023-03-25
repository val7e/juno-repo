package juno.model.cardDeck;

import java.util.ArrayList;

public class DeprecatedDeck {
	
	private ArrayList<DeprecCard> deck;
	private int totalCards = 108;
	
	public DeprecatedDeck() {
		this.deck = new ArrayList<DeprecCard>(totalCards);
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
			for (int j = 0; j < DeprecNumber.values().length; j++) {
				deck.add(new DeprecCardNumber(Color.values()[i], DeprecNumber.values()[j]));
				if (j > 0) {
					deck.add(new DeprecCardNumber(Color.values()[i], DeprecNumber.values()[j]));
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
			for (int j = 0; j < DeprecAction.values().length; j++) {
				deck.add(new DeprecCardAction(Color.values()[i], DeprecAction.values()[j]));
				deck.add(new DeprecCardAction(Color.values()[i], DeprecAction.values()[j]));
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
		for (int i = 0; i < DeprecJolly.values().length; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new DeprecCardJolly(DeprecJolly.values()[i]));
			}
		}
	}
}
