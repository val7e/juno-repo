package juno.model.cardGame;
import juno.model.cardDeck.*;

public class CardsRules {
	public static void whichCard(CardDeprecated card, int size) {
		switch (card.getType()) {
		case "NUMBER": {
			System.out.println("prossimo giocatore");
		}
		case "ACTION": {
			if (card.getAction() == Action.SALTO) {
				System.out.println("currentPlayer butta lo stop e il nextPlayer salta il turno -> calcola nuovo nextPlayer");
			}
			if (card.getAction() == Action.INVERTI) {
				System.out.println("currentPlayer inverte il giro e passa al nextPlayer (controllo con metodo ok)");
			}
			if (card.getAction() == Action.PESCADUE) {
				System.out.println("currentPlayer ha buttato un piu due e quindi nextPlayer pesca due carte e salta il turno");
			}
		}
		case "JOLLY": {
			if (card.getJolly() == DeprecJolly.JOLLYCOLORE) {
				System.out.println("currentPlayer sceglie il nuovo colore");
			}
			if (card.getJolly() == DeprecJolly.JOLLYPESCAQUATTRO && size > 1) {
				System.out.println("currentPlayer sceglie il colore e nextPlayer pesca 4 carte e salta il turno");
			}
			if (card.getJolly() == DeprecJolly.JOLLYPESCAQUATTRO && size == 1) {
				System.out.println("carta non valida, si rimette nel mazzo e si rimischia");
			}
		}
	}
	}
}
