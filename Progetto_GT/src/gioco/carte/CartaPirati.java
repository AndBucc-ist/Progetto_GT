package gioco.carte;

import gioco.Giocatore;

public class CartaPirati extends CartaAvventura{
	
	private int potenzaPirati;
	private int ricompensa;
	
	public CartaPirati(String nome, String descrizione, int prioritaDiEsecuzion, int potenza, int ricompensa, String direzione)throws Exception{
        super(nome, descrizione, prioritaDiEsecuzion, direzione);
        this.potenzaPirati = potenza;
        this.ricompensa = ricompensa;
    }
	    
	public void applicaEffetto(Giocatore giocatore) {
        giocatore.getPlancia().getNave().dannoSubito(potenzaPirati);
    }
	
	
	public int getPotenzaPirati() {
        return potenzaPirati;
    }

    public void setPotenzaPirati(int potenzaPirati) {
        this.potenzaPirati = potenzaPirati;
    }

    public int getRicompensa() {
        return ricompensa;
    }

    public void setRicompensa(int ricompensa) {
        this.ricompensa = ricompensa;
    }
	
	
}
