/**
 * 
 */
package juno.model.gamePlayers;

/**
 * @author val7e
 *
 */
public class PlayerHuman extends Player {
	
	public PlayerHuman(String nickname, Avatar avatar) {
		this.nickname = nickname;
		this.avatar = avatar; //da sostituire con path immagine default
		this.level = "Beginner";
	}
	
	public void addGamesWon() {
		gamesWon++;
	}
	
	public void addGamesLost() {
		gamesLost++;
	}
	
	public void setLevel() {
		//?????? che criterio uso 
	}

}
