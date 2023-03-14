package juno.model.gamePlayers;

public abstract class Player {
	protected String nickname;
	protected Avatar avatar;
	protected String level;
	protected int gamesWon;
	protected int gamesLost;
	
	
	public String getNickname() {
		return this.nickname;
	}
	
	public Avatar getAvatar() {
		return this.avatar;
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
	
	
}
