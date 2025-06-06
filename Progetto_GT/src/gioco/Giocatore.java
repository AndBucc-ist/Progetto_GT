package gioco;

import java.util.ArrayList;

import gioco.errori.NomeDuplicatoException;

public class Giocatore {

	private String nome;
	private PlanciaNave plancia;
	private int punteggio;
	protected static ArrayList<String> listaNomi = new ArrayList<>();
	private int crediti = 0;
    private int equipaggio = 0;
    private int merce = 0;
	
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
			throw new NomeDuplicatoException("Il nome inserito è già stato utilizzato!");
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
	
	
	public void aggiungiCrediti(int quantita) {
        this.crediti = this.crediti + quantita;
    }

    public void aumentaEquipaggio(int quantita) {
        this.equipaggio = this.equipaggio + quantita;
    }

    public void aggiungiMerce(int quantita) {
        this.merce = this.merce + quantita;
    }
    
    public void rimuoviCrediti(int quantita) {
        this.crediti = this.crediti - quantita;
    }

    public void diminuisciEquipaggio(int quantita) {
        this.equipaggio = this.equipaggio - quantita;
    }

    public void rimuoviMerce(int quantita) {
        this.merce = this.merce - quantita;
    }
    
    public int getMerce() {
    	return this.merce;
    }
    
    public void setMerce(int merce) {
    	this.merce = merce;
    }
    
    public void perdiMercePercentuale(int intensitaEvento) {
    	int numeroMerciDaElimianre = (getMerce()/100) * intensitaEvento;
    	
    	setMerce(getMerce()-numeroMerciDaElimianre);
    }
	
	public String toString() {
		return "Giocatore: " + getNome() + "\nPunteggio: " + getPunteggio() + "\n Informazioni plancia: " + getPlancia(); 
	}
	
}
