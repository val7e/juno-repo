/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */

abstract class DeprecCard {
    private final Color color;

    public DeprecCard(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean canPlayOn(Card otherCard);

    @Override
    public String toString() {
        return color.toString();
    }
}
//public abstract class CardDeprecated {
//	protected Color color;
//	protected Action action;
//	protected Number number;
//	protected Jolly jolly;
//	protected String type;
//	protected int score;
//	
//	public Color getColor() {
//		return this.color;
//	}
//	
//	public Number getNumber() {
//		return this.number;
//	}
//	
//	public Action getAction() {
//		return this.action;
//	}
//	
//	public Jolly getJolly() {
//		return this.jolly;
//	}
//	
//	public String getType() {
//		return this.type;
//	}
//	
//	public void setColor(Color newColor) {
//		this.color = newColor;
//	}
//	
//	public abstract String toString();
//	
//	public abstract int getScore();
//}
