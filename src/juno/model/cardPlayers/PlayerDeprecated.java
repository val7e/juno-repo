package juno.model.cardPlayers;

public class PlayerDeprecated {
	protected String nickname;
	protected Avatar avatar;
	protected String level;
	protected boolean isHuman;
	protected int gamesWon;
	protected int gamesLost;
	protected int expPoints = 1;
	
	public PlayerDeprecated(String nickname, boolean isHuman, Avatar avatar) {
		this.nickname = nickname;
		this.isHuman = isHuman;
		this.avatar = avatar;
		this.level = "Newbie";
	}
	
	
	public String getNickname() {
		return this.nickname;
	}
	
	public Avatar getAvatar() {
		return this.avatar;
	}
	
	public boolean isHuman() {
		return this.isHuman;
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
	
	public String toString() {
		return this.getNickname();
	}
	
}
