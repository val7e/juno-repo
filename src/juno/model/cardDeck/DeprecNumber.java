package juno.model.cardDeck;

public enum DeprecNumber {
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
	PESCA_DUE(20),
	COLORE(50),
	PESCA_QUATTRO(50);
	
	
	private static final DeprecNumber[] numbers = DeprecNumber.values();
	
	public static DeprecNumber getNumber (int i) {
		return DeprecNumber.numbers[i];
	}
	
	private final int score;
	
	// This is a constructor
	private DeprecNumber (int score) {
		this.score = score;
	}

	public int getNumberInt() {
		return score;
	}
	
	
}
