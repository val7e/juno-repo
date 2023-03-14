package juno.model.cardDeck;

public enum Number {
	ZERO(0),
	UNO(1),
	DUE(2),
	TRE(3),
	QUATTRO(4),
	CINQUE(5),
	SEI(6),
	SETTE(7),
	OTTO(8),
	NOVE(9);
	
	
	private static final Number[] numbers = Number.values();
	
	public static Number getNumber (int i) {
		return Number.numbers[i];
	}
	
	private final int score;
	
	// This is a constructor
	private Number (int score) {
		this.score = score;
	}

	public int getNumberInt() {
		return score;
	}
	
	
}
