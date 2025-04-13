package gioco.carte;

import gioco.Giocatore;

public class CartaEventoSpeciale extends CartaAvventura{

	public CartaEventoSpeciale(String nome, String descrizione, int prioritaDiEsecuzione) throws Exception {
		super(nome, descrizione, prioritaDiEsecuzione);
	}

	public void applicaEffetto(Giocatore giocatore) {		
	}
}
