package gioco.carte;

import gioco.Giocatore;

public class CartaEventoGenerico extends CartaAvventura{

	private int dannoBase;
	
	public CartaEventoGenerico(String nome, String descrizione, int prioritaDiEsecuzione, int dannoBase, String direzione)throws Exception{
		super(nome, descrizione, prioritaDiEsecuzione,direzione);
        this.dannoBase = dannoBase;
	}

	
	public void applicaEffetto(Giocatore giocatore) {	
		giocatore.getPlancia().getNave().dannoSubito(dannoBase);
	}
	
	
	public int getDannoBase() {
        return dannoBase;
    }

    public void setDannoBase(int dannoBase) {
        this.dannoBase = dannoBase;
    }

}
