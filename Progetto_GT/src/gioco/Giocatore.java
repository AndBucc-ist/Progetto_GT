package gioco;

import java.util.HashSet;
import java.util.Set;

import gioco.errori.NomeDuplicatoException;
/**
 * Rappresenta un giocatore del gioco.
 * Ogni giocatore ha un nome, una plancia nave, un punteggio, dei crediti, un equipaggio e della merce.
 * I nomi dei giocatori devono essere unici.
 */
public class Giocatore {

	private String nome;
	private PlanciaNave plancia;
	private int punteggio;
	protected static Set<String> listaNomi = new HashSet<>();
	private int crediti = 0;
    	private int equipaggio = 0;
    	private int merce = 0;
	     /**
	     * Crea un nuovo giocatore con il nome e la plancia specificati.
	     *
	     * @param nome nome del giocatore (deve essere unico)
	     * @param plancia oggetto PlanciaNave associato al giocatore
	     * @throws Exception se il nome è vuoto o già usato da un altro giocatore
	     */
	public Giocatore(String nome, PlanciaNave plancia) throws Exception {
		setNome(nome);
		setPlancia(plancia);
		setPunteggio(0);
	}
	/**
        * Restituisce il nome del giocatore.
        * @return nome del giocatore
        */
	public String getNome() {
		return nome;
	}
	/**
        * Imposta il nome del giocatore.
        * Il nome non può essere vuoto o già utilizzato.
        *
        * @param nome nuovo nome
        * @throws Exception se il nome è già presente o vuoto
        */
	public void setNome(String nome)throws Exception{
		if(nome.isBlank() || listaNomi.contains(nome)) {
			throw new NomeDuplicatoException("Il nome inserito è già stato utilizzato!");
		}
		
		this.nome = nome;
		listaNomi.add(nome);
	}
        /**
        * Restituisce la plancia del giocatore.
        * @return la plancia nave
        */
	public PlanciaNave getPlancia() {
		return plancia;
	}
	/**
        * Imposta la plancia del giocatore.
        * @param plancia nuova plancia da assegnare
        */
	public void setPlancia(PlanciaNave plancia) {
		this.plancia = plancia;
	}
        /**
        * Restituisce il punteggio del giocatore.
        * @return punteggio attuale
        */
	public int getPunteggio() {
		return punteggio;
	}
        /**
        * Imposta il punteggio del giocatore.
        * @param punteggio nuovo punteggio
        */
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	/**
        * Aggiunge crediti al giocatore.
        * @param quantita quanti crediti aggiungere
        */
	public void aggiungiCrediti(int quantita) {
        this.crediti = this.crediti + quantita;
    }
     /**
     * Aumenta l'equipaggio del giocatore.
     * @param quantita numero di membri da aggiungere
     */
    public void aumentaEquipaggio(int quantita) {
        this.equipaggio = this.equipaggio + quantita;
    }
     /**
     * Aggiunge merce al giocatore.
     * @param quantita quantità da aggiungere
     */
    public void aggiungiMerce(int quantita) {
        this.merce = this.merce + quantita;
    }
     /**
     * Rimuove crediti al giocatore.
     * @param quantita quanti crediti rimuovere
     */
    public void rimuoviCrediti(int quantita) {
        this.crediti = this.crediti - quantita;
    }
     /**
     * Diminuisce l'equipaggio del giocatore.
     * @param quantita numero di membri da togliere
     */
    public void diminuisciEquipaggio(int quantita) {
        this.equipaggio = this.equipaggio - quantita;
    }
    /**
     * Rimuove della merce dal giocatore.
     * @param quantita quantità da rimuovere
     */
    public void rimuoviMerce(int quantita) {
        this.merce = this.merce - quantita;
    }
     /**
     * Restituisce la quantità di merce posseduta.
     * @return merce attuale
     */
    public int getMerce() {
    	return this.merce;
    }
     /**
     * Imposta il valore della merce posseduta.
     * @param merce nuova quantità di merce
     */
    public void setMerce(int merce) {
    	this.merce = merce;
    }
     /**
     * Riduce la merce in base a una percentuale passata.
     * Usato ad esempio quando accade un evento negativo.
     *
     * @param intensitaEvento percentuale da togliere
     */
    public void perdiMercePercentuale(int intensitaEvento) {
    	int numeroMerciDaElimianre = (getMerce()/100) * intensitaEvento;
    	
    	setMerce(getMerce()-numeroMerciDaElimianre);
    }
     /**
     * Restituisce una descrizione testuale del giocatore.
     * @return stringa con nome, punteggio e plancia
     */
	public String toString() {
		return "Giocatore: " + getNome() + "\nPunteggio: " + getPunteggio() + "\n Informazioni plancia: " + getPlancia(); 
	}
	
}
