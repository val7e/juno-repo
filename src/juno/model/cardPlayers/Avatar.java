package juno.model.cardPlayers;

import java.util.Random;

public enum Avatar {
	USER, 
	PAM, 
	JIM, 
	DWIGHT;
	
	private static final Random i = new Random();
	
	public Avatar randomAvatar() {
		Avatar[] avatars = values();
		return avatars[i.nextInt(avatars.length)];
	}
	
	
}
