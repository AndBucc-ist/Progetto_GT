package gioco.carte;

import gioco.Giocatore;

public abstract class CartaAvventura {

	private final String nome;
	private final String descrizione;
	private int prioritaDiEsecuzione;
	private String direzione;
	
	public CartaAvventura(String nome, String descrizione, int prioritaDiEsecuzione, String direzione)throws Exception {
		
		if(nome.isBlank() || descrizione.isBlank()) {
			throw new Exception("Carta non valida!");
		}
		
		this.nome = nome;
		this.descrizione = descrizione;
		this.prioritaDiEsecuzione = prioritaDiEsecuzione;
		this.direzione = direzione;
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
	
	public String getDirezione() {
        return direzione;
    }

    public void setDirezione(String direzione) {
        this.direzione = direzione;
    }
	
	public String toString() {
		return "Nome carta: " + getNome() + "; Descrizione carta: " + getDescrizione() + "; Direzione carta: " + getDirezione();
	}
	
}
