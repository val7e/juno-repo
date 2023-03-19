/**
 * 
 */
package juno.model.cardGame;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;

import juno.model.cardDeck.Card;
import juno.model.cardPlayers.*;

/**
 * @author val7e
 *
 */
public class PlayersIterator {
	private Player[] players;
	private int current = 0;
	private Direction direction = Direction.CLOCKWISE;
	
	public PlayersIterator(Player[] players) {
		this.players = players;
	}
	
	/**
	 * This method returns a stream of the players nicknames.
	 * @return
	 */
	public Stream<Player> stream() {
		return Arrays.stream(players);
		
	}
	
	public Player[] getPlayers(){
		return players;
	}
	
	public Player getCurrentPlayer() {
		return players[current];
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
		return (players.length + current + increment) % players.length;
	}
	
	public Player nextPlayer() {
		current = getNextPlayerIndex();
		return getCurrentPlayer();
	}
	
	
}