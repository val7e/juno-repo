package juno.model.cardPlayers;

import juno.model.cardDeck.*;
import java.util.ArrayList;

public class Player {
    private final String nickname;
    private String avatar;
    protected final ArrayList<Card> hand;
    private String level;
	private int gamesWon;
	private int gamesLost;
	private int expPoints = 1;

    public Player(String nickname) {
        this.nickname = nickname;
        this.hand = new ArrayList<Card>();
    }

    public String getNickname() {
        return nickname;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }
    
    public Card playCard(Color color, Value value) {
        for (Card card : hand) {
            if (card.getColor() == color && card.getValue() == value) {
                hand.remove(card);
                return card;
            }
        }
        return null;
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    
    public String getLevel() {
		return this.level;
	}
	
	public int getGamesWon() {
		return this.gamesWon;
	}
	
	public int getGamesLost() {
		return this.gamesLost;
	}
	
	public void addGamesWon() {
		this.gamesWon++;
		this.expPoints *= 2;
		setLevel();
	}
	
	public void addGamesLost() {
		gamesLost++;
	}
	
	public int getExpPoints() {
		return this.expPoints;
	}
	/**
	 * This is method is invoked at the end of every game, after 
	 * the counting points.
	 */
	public void setLevel() {
		if (expPoints >= 64) this.level = "Beginner";
		if (expPoints >= 512) this.level = "Intermediate";
		if (expPoints >= 4096) this.level = "Advanced";
	}
	
//    public Card getCard(int index) {
//        return hand.get(index);
//    }
//
//    public boolean hasCard(Card card) {
//        return hand.contains(card);
//    }
}
