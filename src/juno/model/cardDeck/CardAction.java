/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public class CardAction extends Card {
	
	/**
	 * This is the constructor method
	 * 
	 * @param color
	 * @param action
	 */
	public CardAction (Color color, Action action) {
		this.color = color;
		this.action = action;
	}
	
	private final int score = 20;
	
	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return this.getColor() + " " + this.getAction();
	}
}
