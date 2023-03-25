/**
 * 
 */
package juno.model.cardGame;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import juno.model.cardDeck.Card;
import juno.model.cardPlayers.*;


/**
 * @author val7e
 *
 */
public class PlayersIterator {
	private List<Player> players;
	private HashMap<String, List<Card>> handsMap;
	private int current = 0;
	private Direction direction = Direction.CLOCKWISE;
	
	public PlayersIterator(List<Player> players) {
		this.players = players;
		this.handsMap = new HashMap<String, List<Card>>();
	}
	
	/**
	 * This method returns a stream of the players nicknames.
	 * @return
	 */
//	public Stream<Player> stream() {
//		return Arrays.stream(players);
//		
//	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public Player getCurrentPlayer() {
		return players.get(current);
	}
	
	/**
	 * The default direction in the game is from left to right,
	 * so clockwise.
	 */
	public void reverseDirection() {
		direction = Direction.COUNTER_CLOCKWISE;
	}
	
	public int getNextPlayerIndex() {
		var increment = direction == Direction.CLOCKWISE ? 1 : -1;
		return (players.size() + current + increment) % players.size();
	}
	
	public Player nextPlayer() {
		current = getNextPlayerIndex();
		return getCurrentPlayer();
	}
	
	public HashMap<String, List<Card>> getHandsMap() {
		return handsMap;
	}
	
	
	
}