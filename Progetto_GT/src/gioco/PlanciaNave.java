package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;

public class PlanciaNave {

	private Nave nave; 
	private int posizionePartenza;
	private int punteggioNave;
	
	public PlanciaNave(int posizionePartenza)throws Exception {
		nave = new Nave(new ArrayList<>());
		setPosizionePartenza(posizionePartenza);
	}
	
	public void planciaValida() {
		//Bisogna implementare i controlli per vedere se l'utente ha aggiunto un componente che non può essere piazzato in quella posizione
		//Si modifica punteggioNave a seconda che il componente sia messo in maniera corretta oppure no
		//Se planciaValida è True aggiungi 1 altrimenti 0
		//setPunteggioNave(0) se False, setPunteggioNave(1) se True
		
		//Per verificare se il componente inserito sia valido, controllo l'orientamento (NORD, SUD, EST, OVEST)
		//NORD deve coincidere con NORD e così via per gli altri
		
	}

	public void setPunteggioNave(int punti) {
		punteggioNave = punteggioNave + punti;
	}
	
	public int getPunteggioNave() {
		return punteggioNave;
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
