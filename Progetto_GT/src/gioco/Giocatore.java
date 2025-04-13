package gioco;

import java.util.ArrayList;

public class Giocatore {

	private String nome;
	private PlanciaNave plancia;
	private int punteggio;
	protected static ArrayList<String> listaNomi = new ArrayList<>();
	
	public Giocatore(String nome, PlanciaNave plancia) throws Exception {
		setNome(nome);
		setPlancia(plancia);
		setPunteggio(0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)throws Exception{
		if(nome.isBlank() || listaNomi.contains(nome)) {
			throw new Exception("Il nome inserito è già stato utilizzato!");
		}
		
		this.nome = nome;
		listaNomi.add(nome);
	}

	public PlanciaNave getPlancia() {
		return plancia;
	}

	public void setPlancia(PlanciaNave plancia) {
		this.plancia = plancia;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public String toString() {
		return "Giocatore: " + getNome() + "\nPunteggio: " + getPunteggio() + "\n Informazioni plancia: " + getPlancia(); 
	}
	
}
