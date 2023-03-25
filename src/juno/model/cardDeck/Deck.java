/**
 * 
 */
package juno.model.cardDeck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author val7e
 *
 */


public class Deck {
    private final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Color color : Color.values()) {
            if (color == Color.JOLLY) continue;
            for (Value value : Value.values()) {
                if (value == Value.CAMBIO_COLORE || value == Value.PIU_QUATTRO) continue;
                cards.add(new Card(color, value, value.getScore()));
                if (value != Value.ZERO) {
                    cards.add(new Card(color, value, value.getScore()));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(Color.JOLLY, Value.CAMBIO_COLORE, Value.CAMBIO_COLORE.getScore()));
            cards.add(new Card(Color.JOLLY, Value.PIU_QUATTRO, Value.PIU_QUATTRO.getScore()));
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    public Card drawCard() {
        return cards.remove(0);
    }
    
    public String getDeck() {
    	return cards.toString();
    }
    
    public void restartInvalidDeck(Card card) {
		cards.add(card);
		shuffleCards();
	}
}
