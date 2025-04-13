package gioco.carte;

import gioco.Giocatore;

public class CartaEventoGenerico extends CartaAvventura{

	private int dannoBase;
	
	public CartaEventoGenerico(String nome, String descrizione, int prioritaDiEsecuzione, int dannoBase)throws Exception{
		super(nome, descrizione, prioritaDiEsecuzione);
        this.dannoBase = dannoBase;
	}

	
	public void applicaEffetto(Giocatore giocatore) {	
		giocatore.getPlancia().getNave().dannoSubito(dannoBase);
	}
	
}
