package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;

public class PlanciaNave {

	private Giocatore giocatore;
	private ArrayList<ComponenteNave> componentiNave = new ArrayList<>(); 
	private int posizionePartenza;
	
	public PlanciaNave(Giocatore giocatore, ArrayList<ComponenteNave> componentiNave, int posizionePartenza)throws Exception {
		setGiocatore(giocatore);
		setComponentiNave(componentiNave);
		setPosizionePartenza(posizionePartenza);
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void aggiungiComponente(ComponenteNave elemento) {
	    componentiNave.add(elemento);
	}
	
	public boolean planciaValida() {
		//Bisogna implementare i controlli per vedere se l'utente ha aggiunto un componente che non può essere piazzato in quella posizione
		return true;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public ArrayList<ComponenteNave> getComponentiNave() {
		return componentiNave;
	}

	public void setComponentiNave(ArrayList<ComponenteNave> componentiNave)throws Exception {
		if(componentiNave.isEmpty()) {
			throw new Exception("Nessun componente presente!");
		}
		
		this.componentiNave = componentiNave;
	}

	public int getPosizionePartenza() {
		return posizionePartenza;
	}

	public void setPosizionePartenza(int posizionePartenza)throws Exception {
		if(posizionePartenza < 0) {
			throw new Exception("Posizione non valida!");
		}
		
		this.posizionePartenza = posizionePartenza;
	}
	
	public String toString() {
		return "PlanciaNave { \nGiocatore: " + getGiocatore().toString() + "\n Componenti della nave: " + getComponentiNave().toString() + "\n}";
	}
	
}
