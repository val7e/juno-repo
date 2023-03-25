/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public class DeprecCardNumber extends DeprecCard {
	
	/**
	 * This is the constructor method
	 * @param color 
	 * @param number
	 */
	public DeprecCardNumber (Color color, DeprecNumber number) {
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

