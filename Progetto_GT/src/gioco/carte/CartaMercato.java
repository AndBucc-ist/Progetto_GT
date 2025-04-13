package gioco.carte;

import gioco.Giocatore;

public class CartaMercato extends CartaAvventura{

	public CartaMercato(String nome, String descrizione, int prioritaDiEsecuzione) throws Exception {
		super(nome, descrizione, prioritaDiEsecuzione);
	}

	@Override
	public void applicaEffetto(Giocatore giocatore) {		
	}

}
