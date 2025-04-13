package gioco.carte;

import gioco.Giocatore;

public class CartaPirati extends CartaAvventura{
	
	private int potenzaPirati;
	private int ricompensa;
	
	public CartaPirati(String nome, String descrizione, int prioritaDiEsecuzion, int potenza, int ricompensa)throws Exception{
        super(nome, descrizione, prioritaDiEsecuzion);
        this.potenzaPirati = potenza;
        this.ricompensa = ricompensa;
    }
	    
	
	public void applicaEffetto(Giocatore giocatore) {
        giocatore.getPlancia().getNave().dannoSubito(potenzaPirati);
        //Dobbiamo aggiungere gli altri ipotetici controlli
    }
}
