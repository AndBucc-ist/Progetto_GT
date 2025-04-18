package gioco.carte;

import java.util.ArrayList;

public class Mazzo {
	
	private ArrayList<CartaAvventura> mazzoCarte;
	
	public Mazzo() {
		// Ci sono 3 livelli: 1 - Sono 8 carte 2 e 3 non so
		mazzoCarte = new ArrayList<>();
		
	}

	public void aggiungiCarteLivelloUno(ArrayList<CartaAvventura> mazzo) {
		int count = 0;
		//Aggiungo esattamente 8 carte, indipendentemente da quante ne vengano passate così formo il mazzo da 8
		if(mazzo.size() >= 8) {
			for(CartaAvventura elemento: mazzo) {
				if(count == 8) {
					break;
				}
				
				mazzoCarte.add(elemento);
				count++;
			}
		}
	}
	
}
