/**
 * 
 */
//package juno.model.cardGame;
//
//import juno.model.cardDeck.*;
//import juno.model.cardPlayers.Player;
//
//
//import java.util.List;
//import java.util.Stack;
//import java.util.TreeMap;
//import java.util.stream.*;
//
///**
// * @author val7e
// *
// */
//public class GameDeprecated {
//	private static Deck currentDeck = new Deck();
//	private static Stack<Card> discardDeck;
//	private static PlayersRoundBuffer players;
//	
//	private static TreeMap<String, List<Card>> playersHandMap = new TreeMap<String, List<Card>>();
//	
//	
//	private int currentPlayer; // the player that has to play
//	private String[] playerIds; //array of the nicknames of the players
//	
//	//private Deck currentDeck; //the deck that the players are playing with
//	//private Stack<Card> stockPile;
//	
//	boolean gameDirection;
//	
//	public GameDeprecated(PlayersRoundBuffer players) {
//		GameDeprecated.players = players;
//		currentPlayer = 0;
//	}
//	
//	public int getDiscardDeckSize() {
//		System.out.println("Size: " + discardDeck.size());
//		return discardDeck.size();
//	}
//	
//	
//	
//	public void start() {
//		currentDeck = new Deck();
//		discardDeck = new Stack<Card>();
//		gameDirection = false;
//		
//		for (Player p : players.getPlayers()) {
//			playersHandMap.put(p.getNickname(), currentDeck.getPlayerHand());
//		}
//		System.out.println(playersHandMap.getClass());
//		
//		Card card = currentDeck.drawCard();
//		System.out.println("CURRENT CARD: " + card);
//		discardDeck.add(card); //aggiungo carta agli scarti
//		int size = getDiscardDeckSize();
//		System.out.println(playersHandMap.get("val7e").getClass());
//		Color color = card.getColor();
//		var value = card.getType().equals("ACTION") ? card.getAction() :
//			card.getType().equals("JOLLY")? card.getJolly():card.getNumber();
//		System.out.println(value);
//			
////		var giocabili = playersHandMap.get("val7e").stream()
////				.filter(w -> w.getNumber() == value || w-> w.getAction() == value).collect(Collectors.toList());
////		
//		String abc = "abc";
//		
//		System.out.println(abc.contains("bc"));
//		
////		var giocabili = playersHandMap.get(players.getCurrentPlayer()).stream()
////			.filter(w -> w.getNumber() == value || w -> w.getAction() == value || w -> w.getColor() == color || w -> w.getType().equals("JOLLY")).collect(Collectors.toList());
////		Stream<Card> fNumero = playersHandMap.get(players.getCurrentPlayer()).stream()
////				.filter(n -> n.getNumber() == card.getNumber());
////		Stream<Card> fAzione = playersHandMap.get(players.getCurrentPlayer()).stream()
////				.filter(a -> a.getAction() == card.getAction());
////		Stream<Card> fJolly = playersHandMap.get(players.getCurrentPlayer()).stream()
////				.filter(j -> j.getJolly() == Jolly.JOLLYCOLORE);
////		List<Card> result = Stream.concat(Stream.concat(Stream.concat(fColore, fNumero), fAzione), fJolly).collect(Collectors.toList());
////		
////		if (card.getColor() != null) {
////			Stream<Card> filtroColore = playersHandMap.get(players.getPlayers()[0]).stream().filter(w -> w.getColor() == card.getColor());
////			System.out.println("CARTE GIOCABILI COLORE: " + filtroColore);
////			if (filtroColore.isEmpty()) {
////				Stream<Card> filtroJolly = playersHandMap.get(players.getPlayers()[0]).stream().filter(w -> w.getJolly() == Jolly.JOLLYPESCAQUATTRO);
////				System.out.println("JOLLY 4 GIOCABILE: " + filtroJolly);
////			}
////		}
////		if (card.getNumber() != null) {
////			Stream<Card> filtroNumero = playersHandMap.get(players.getPlayers()[0]).stream().filter(w -> w.getNumber() == card.getNumber());
////			System.out.println("CARTE GIOCABILI NUMERO: " + filtroNumero);
////		}
////		if (card.getAction() != null) {
////			Stream<Card> filtroAzione = playersHandMap.get(players.getPlayers()[0]).stream().filter(w -> w.getAction() == card.getAction());
////			System.out.println("CARTE GIOCABILI AZIONE: " + filtroAzione);
////		}
////		else {
////			Stream<Card> filtroJolly = playersHandMap.get(players.getPlayers()[0]).stream().filter(w -> w.getJolly() == Jolly.JOLLYCOLORE);
////			System.out.println("CARTE GIOCABILI JOLLY: " + filtroJolly);
////		}
////		
////		
//		abstract class CardsRules {
//			public static void whichCard(Card card, int size) {
//				switch (card.getType()) {
//					case "Number": {
//						System.out.println("prossimo giocatore");
//					}
//					case "Action": {
//						if (card.getAction() == Action.SALTO) {
//							players.nextPlayer();
//							System.out.println("currentPlayer butta lo stop e il nextPlayer salta il turno -> calcola nuovo nextPlayer");
//						}
//						if (card.getAction() == Action.INVERTI) {
//							players.reverseDirection();
//							players.getCurrentPlayer();
//							players.nextPlayer();
//							System.out.println("currentPlayer inverte il giro e passa al nextPlayer (controllo con metodo ok)");
//						}
//						if (card.getAction() == Action.PESCADUE) {
//							players.nextPlayer();
//							System.out.println("currentPlayer ha buttato un piu due e quindi nextPlayer pesca due carte e salta il turno");
//						}
//					}
//					case "Jolly": {
//						if (card.getJolly() == Jolly.JOLLYCOLORE) {
//							players.nextPlayer();
//							System.out.println("currentPlayer sceglie il nuovo colore");
//						}
//						if (card.getJolly() == Jolly.JOLLYPESCAQUATTRO && size > 1) {
//							players.nextPlayer();
//							System.out.println("currentPlayer sceglie il colore e nextPlayer pesca 4 carte e salta il turno");
//						}
//						if (card.getJolly() == Jolly.JOLLYPESCAQUATTRO && size == 1) {
//							System.out.println("carta non valida, si rimette nel mazzo e si rimischia");
//							currentDeck.restartInvalidDeck(card); //riaggungo la carta e rimischio il mazzo
//							card = currentDeck.drawCard();
//						}
//					}
//				}
//			}
//		}
//		
//		CardsRules.whichCard(card, size);
//		
//		
//	}
//	
//}
