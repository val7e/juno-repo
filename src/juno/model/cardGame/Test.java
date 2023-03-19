package juno.model.cardGame;

import juno.model.cardDeck.*;
import juno.model.cardPlayers.*;

public class Test {

	public static void main(String[] args) {
		
		//array di giocatori va costrutito in un metodo di avvio della partita
		Deck deck1 = new Deck();
		Game game1 = new Game(deck1);
		game1.start("val7e");
		
		
		
	} 

}
