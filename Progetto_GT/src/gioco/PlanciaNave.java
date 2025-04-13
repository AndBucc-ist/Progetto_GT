package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;

public class PlanciaNave {

	private Nave nave; 
	private int posizionePartenza;
	
	public PlanciaNave(int posizionePartenza)throws Exception {
		nave = new Nave(new ArrayList<>());
		setPosizionePartenza(posizionePartenza);
	}
	
	public boolean planciaValida() {
		//Bisogna implementare i controlli per vedere se l'utente ha aggiunto un componente che non può essere piazzato in quella posizione
		return true;
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
	
	public Nave getNave() {
		return this.nave;
	}
	
	public String toString() {
		return "PlanciaNave {\nInformazioni della nave: " + getNave().toString() + "\n}";
	}
	
}
