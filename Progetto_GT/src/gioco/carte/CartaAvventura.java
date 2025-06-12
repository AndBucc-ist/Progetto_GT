package gioco.carte;

import gioco.Giocatore;
 /**
 * Classe astratta che rappresenta una carta avventura.
 * Ogni carta ha un nome, una descrizione, una priorità di esecuzione e una direzione.
 * Le carte avventura applicano un effetto specifico sul giocatore.
 */
public abstract class CartaAvventura {

	private final String nome;
	private final String descrizione;
	private int prioritaDiEsecuzione;
	private String direzione;
     /**
     * Costruisce una carta avventura con nome, descrizione, priorità di esecuzione e direzione.
     * 
     * @param nome nome della carta (non vuoto)
     * @param descrizione descrizione della carta (non vuota)
     * @param prioritaDiEsecuzione priorità per l'ordine di esecuzione
     * @param direzione direzione associata alla carta
     * @throws Exception se nome o descrizione sono vuoti
     */
	public CartaAvventura(String nome, String descrizione, int prioritaDiEsecuzione, String direzione)throws Exception {
		
		if(nome.isBlank() || descrizione.isBlank()) {
			throw new Exception("Carta non valida!");
		}
		
		this.nome = nome;
		this.descrizione = descrizione;
		this.prioritaDiEsecuzione = prioritaDiEsecuzione;
		this.direzione = direzione;
	}

     /**
     * Metodo astratto da implementare per applicare l'effetto della carta al giocatore.
     * 
     * @param giocatore il giocatore su cui applicare l'effetto
     */
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
