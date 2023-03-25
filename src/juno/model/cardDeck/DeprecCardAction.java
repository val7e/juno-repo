/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public class DeprecCardAction extends DeprecCard {
	
	/**
	 * This is the constructor method
	 * 
	 * @param color
	 * @param action
	 */
	public DeprecCardAction (Color color, DeprecAction action) {
		this.color = color;
		this.action = action;
		this.type = "Action";
	}
	
	private final int score = 20;
	
	public String getType() {
		return this.type;
	}
	
	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return this.getColor() + " " + this.getAction();
	}
}
