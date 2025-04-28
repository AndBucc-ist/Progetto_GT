package gioco;

import gioco.carte.Mazzo;

public class Gioco {

	private Mazzo mazzoCarte;
	
	public Gioco() {
	}
	
	public void iniziaPartita() {
		
		try {
			mazzoCarte = new Mazzo();
			mazzoCarte.caricaCarte();
			mazzoCarte.mischiaMazzo();
			
			
		}catch(Exception h){
			h.printStackTrace();
		}
	}
	
}
