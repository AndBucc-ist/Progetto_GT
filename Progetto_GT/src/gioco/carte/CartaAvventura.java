package gioco.carte;

import gioco.Giocatore;

public abstract class CartaAvventura {

	private final String nome;
	private final String descrizione;
	private int prioritaDiEsecuzione;
	
	public CartaAvventura(String nome, String descrizione, int prioritaDiEsecuzione)throws Exception {
		
		if(nome.isBlank() || descrizione.isBlank()) {
			throw new Exception("Carta non valida!");
		}
		
		this.nome = nome;
		this.descrizione = descrizione;
		this.prioritaDiEsecuzione = prioritaDiEsecuzione;
	}

	
	public abstract void applicaEffetto(Giocatore giocatore);
	
	
	public int getPrioritaDiEsecuzione() {
		return prioritaDiEsecuzione;
	}

	public void setPrioritaDiEsecuzione(int prioritaDiEsecuzione) {
		this.prioritaDiEsecuzione = prioritaDiEsecuzione;
	}


	public String getNome() {
		return nome;
	}


	public String getDescrizione() {
		return descrizione;
	}
	
	
	public String toString() {
		return "Nome carta: " + getNome() + "; Descrizione carta: " + getDescrizione();
	}
	
}
