package juno.model.cardDeck;

public class Test {

	public static void main(String[] args) {
		
		Deck prova2 = new Deck();
		
		System.out.println("Starter deck: " + prova2.getDeck());
		prova2.shuffleCards();
		System.out.println("Mixed deck: " + prova2.getDeck());
		Card uno = prova2.drawCard();
		System.out.println();
		System.out.println("Card: " + uno.toString() + "\nPoints : " + uno.getScore());
		System.out.println(prova2.getPlayerHand());
		
	} 

}
