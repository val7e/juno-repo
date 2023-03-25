/**
 * 
 */
package juno.model.cardDeck;

/**
 * @author val7e
 *
 */
public enum Value {
	ZERO(0),
	UNO(1),
	DUE(2),
	TRE(3),
	QUATTRO(4),
	CINQUE(5),
	SEI(6),
	SETTE(7),
	OTTO(8),
	NOVE(9),
	SALTO(20),
	INVERTI(20),
	PIU_DUE(20),
	CAMBIO_COLORE(50),
	PIU_QUATTRO(50);
	
	private final int score;
	
	private Value (int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
}
