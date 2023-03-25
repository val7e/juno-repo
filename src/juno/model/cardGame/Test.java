package juno.model.cardGame;

import java.util.ArrayList;
import java.util.List;

import juno.model.cardDeck.*;
import juno.model.cardPlayers.*;

public class Test {

	public static void main(String[] args) {
		
		//array di giocatori va costrutito in un metodo di avvio della partita
		Player playerUser = new Player("val7e");
		Player playerBot0 = new Player("jim");
		Player playerBot1 = new Player("pam");	
		Player playerBot2 = new Player("dwight");
			
		List<Player> players = new ArrayList<Player>();
		players.add(playerUser);
		players.add(playerBot0);
		players.add(playerBot1);
		players.add(playerBot2);
		
		UnoGame game1 = new UnoGame(players);
		game1.start();
		
		
		
	} 

}
