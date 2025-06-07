package gioco;

import java.util.Random;

public enum Orientamento {
	NORD, SUD, EST, OVEST;
	
	public static Orientamento orientamentoCasuale() {
		Random rand = new Random();
		int h = rand.nextInt(4)+1;
		
		switch(h) {
			case 1: return Orientamento.NORD;
			case 2: return Orientamento.SUD;
			case 3: return Orientamento.EST;
			case 4: return Orientamento.OVEST;
			default: return Orientamento.NORD;	
		}
	}
}
