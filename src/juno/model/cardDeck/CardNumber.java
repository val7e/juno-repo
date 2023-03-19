/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public class CardNumber extends Card {
	
	/**
	 * This is the constructor method
	 * @param color 
	 * @param number
	 */
	public CardNumber (Color color, Number number) {
		this.color = color;
		this.number = number;
		this.type = "Number";
	}
	
	public String getType() {
		return this.type;
	}
	
	@Override
	public int getScore() {
		return this.getNumber().getNumberInt();
	}

	@Override
	public String toString() {
		return this.getColor() + " " + this.getNumber();
	}
}

