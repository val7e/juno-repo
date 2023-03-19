package juno.model.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

import juno.model.cardDeck.Card;
import juno.model.cardDeck.CardJolly;
import juno.model.cardDeck.Color;
import juno.model.cardDeck.Deck;
import juno.model.cardDeck.Jolly;
import juno.model.cardPlayers.Player;
import juno.model.cardPlayers.Avatar;

/**
 * 
 * @author val7e
 * 
 * The field currentDeck is the deck of the game
 * The field discardDeck is the pile of discard cards
 *
 */
public class Game {
	
	private Deck currentDeck = new Deck();
	private Stack<Card> discardDeck = new Stack<Card>();
	private Player[] players;
	
	
	private static TreeMap<String, List<Card>> playersHands = new TreeMap<String, List<Card>>();
	
	public Game(Deck currentDeck) {
		this.currentDeck = currentDeck;
	}
	/**
	 * This method initialize the game following these points:
	 * 1. gives 7 cards for each player in players
	 * 2. it extracts the initial card from the currentDeck
	 * 3. adds the initial card to the discardDeck
	 * 4. invokes getPlayableCards, a class method that filters each players hand to find the playable cards
	 */
	
	public void start(String user) {
		
		//costruisco lista di Player
		players = initPlayers(user);
		
		//costruisco iteratore dei giocatori
		PlayersIterator iterator = new PlayersIterator(players);
		
		//costruisco le mani dei giocatori con l'iteratore
		playersHands = getPlayersHands(currentDeck, iterator);
		System.out.println(playersHands);
		
		//pesco la prima carta
//		Card drawnCard = currentDeck.drawCard();
		Card drawnCard = new CardJolly(Jolly.JOLLYPESCAQUATTRO);
		System.out.println("2. " + drawnCard);
		
		//aggiungo controllo isValidCard (pesca4 non valido)
		if (currentDeck.checkInvalidInitCard(drawnCard)) {
			currentDeck.restartInvalidDeck(drawnCard);
			drawnCard = currentDeck.drawCard();
		}
		
		
		//scarto la prima carta
		discardDeck.add(drawnCard);
		System.out.println("3. " + discardDeck);
		
		List<Card> playableCards = getPlayableCards(drawnCard, iterator);
		
		System.out.println(playableCards);
		
		
	}
	
	/**
	 * This method creates a Player array
	 * @param name of the only real player of the game
	 * @return
	 */
	public Player[] initPlayers(String name) {
		Player playerUser = new Player(name, true, Avatar.USER);
		Player playerBot0 = new Player("jim", false, Avatar.JIM);
		Player playerBot1 = new Player("pam", false, Avatar.PAM);	
		Player playerBot2 = new Player("dwight", false, Avatar.DWIGHT);
			
		Player[] builtPlayers = {playerUser, playerBot0, playerBot1, playerBot2};
		return builtPlayers;
	}
	
	public TreeMap<String, List<Card>> getPlayersHands(Deck currentDeck, PlayersIterator iterator) {
		
		for (Player p : iterator.getPlayers()) {
			playersHands.put(p.getNickname(), currentDeck.getPlayerHand());
		}
		return playersHands;
		
	}
	
	public List<Card> getPlayableCards(Card drawnCard, PlayersIterator iterator) {
		var card = drawnCard.getType().equals("Action")? drawnCard.getAction() :
			drawnCard.getType().equals("Jolly")? drawnCard.getJolly() : drawnCard.getNumber();
		
		var currentPlayer = iterator.getCurrentPlayer().getNickname();
		System.out.println(currentPlayer + playersHands.get(iterator.getCurrentPlayer().getNickname()));
		var playableCards = playersHands.get(iterator.getCurrentPlayer().getNickname())
				.stream().filter(w -> w.getNumber()==card || w.getAction()==card || w.getColor()==drawnCard.getColor() || w.getType()=="Jolly").collect(Collectors.toList());
		return playableCards.stream().filter(x->x.getColor()==drawnCard.getColor()).count()>0? 
			       playableCards.stream().filter(x->x.getJolly()!=Jolly.JOLLYPESCAQUATTRO).collect(Collectors.toList()):playableCards;
	}
}
