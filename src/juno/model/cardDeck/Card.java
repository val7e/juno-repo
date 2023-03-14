/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public abstract class Card {
	protected Color color;
	protected Action action;
	protected Number number;
	protected Jolly jolly;
	protected int score;
	
	public Color getColor() {
		return this.color;
	}
	
	public Number getNumber() {
		return this.number;
	}
	
	public Action getAction() {
		return this.action;
	}
	
	public Jolly getJolly() {
		return this.jolly;
	}
	
	public abstract String toString();
	
	public abstract int getScore();
}
