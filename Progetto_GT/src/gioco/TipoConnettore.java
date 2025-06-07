package gioco;

import java.util.Random;

public enum TipoConnettore {
	SEMPLICE, DOPPIO, UNIVERSALE, NESSUNO;

	public static TipoConnettore connettoreCasuale() {
		Random rand = new Random();
		int h = rand.nextInt(4)+1;
		
		switch(h) {
			case 1: return TipoConnettore.SEMPLICE;
			case 2: return TipoConnettore.DOPPIO;
			case 3: return TipoConnettore.UNIVERSALE;
			case 4: return TipoConnettore.NESSUNO;
			default: return TipoConnettore.NESSUNO;	
		}
	}
}
