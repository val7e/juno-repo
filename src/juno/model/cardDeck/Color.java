package juno.model.cardDeck;

public enum Color {
	ROSSO("Rosso"), 
	GIALLO("Giallo"), 
	BLU("Blu"), 
	VERDE("Verde");
	
	private final String colorName;
	
	// This is a constructor
	private Color(String colorName) {
		this.colorName = colorName;
	}
	
	// This public method is for return the color in more human way
	public String printColor() {
		return colorName;
	}
 	
	private static final Color[] colors = Color.values();
	
	public static Color getColor (int i) {
		return Color.colors[i];
	}
}
