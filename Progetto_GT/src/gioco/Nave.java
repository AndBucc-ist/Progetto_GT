package gioco;

import java.util.ArrayList;

import gioco.componente.Cannone;
import gioco.componente.ComponenteNave;
 /**
 * Rappresenta una nave spaziale con vari componenti, vita, energia e armi.
 * 
 * Ogni nave può subire danni, avere scudi, motori attivi e cannoni.
 */
public class Nave {

	private int vita; 
    private ArrayList<ComponenteNave> componenti;
    private int scudiAttivi;
    private int energiaDisponibile;
    private boolean motoreAttivo;
    private int armiAttive;
    private ComponenteNave[][] griglia = new ComponenteNave[10][10];
     /**
     * Crea una nuova nave con i componenti passati e inizializza i valori.
     *
     * @param componenti lista dei componenti da inserire nella nave
     */
    public Nave(ArrayList<ComponenteNave> componenti) {
        this.componenti = new ArrayList<>(componenti);
        this.vita = 100; 
        this.scudiAttivi = 0;
        this.energiaDisponibile = 10;
        this.motoreAttivo = true;
        this.armiAttive = contaCannoniAttivi();
    }
     /**
     * Riduce la vita della nave in base al danno ricevuto.
     *
     * @param danno quantità di danno da subire
     */
    public void dannoSubito(int danno) {
    	int valore = getVita() - danno;
    	
    	if(valore>0) {
    		setVita(danno);
    	}else {
    		setVita(0);
    	}
    	System.out.println("Danno subito. Vita rimasta: " + getVita());
    }
	
     /**
     * Controlla se la nave è stata distrutta (vita = 0).
     *
     * @return true se la nave è distrutta, false altrimenti
     */
   
    public boolean Distrutta() {
    	return getVita() <= 0;
    }
     /**
     * Controlla se ci sono scudi attivi.
     *
     * @return true se ci sono scudi attivi, false altrimenti
     */
    public boolean haScudi() {
        return getScudiAttivi() > 0;
    }
    
    
	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getScudiAttivi() {
		return scudiAttivi;
	}

	public void setScudiAttivi(int scudiAttivi) {
		this.scudiAttivi = scudiAttivi;
	}

	public int getEnergiaDisponibile() {
		return energiaDisponibile;
	}

	public void setEnergiaDisponibile(int energiaDisponibile) {
		this.energiaDisponibile = energiaDisponibile;
	}

	public boolean isMotoreAttivo() {
		return motoreAttivo;
	}

	public void setMotoreAttivo(boolean motoreAttivo) {
		this.motoreAttivo = motoreAttivo;
	}
 
    public ArrayList<ComponenteNave> getComponenti() {
    	return componenti; 
    }
     /**
     * Aggiunge un componente alla lista della nave.
     *
     * @param elemento il componente da aggiungere
     */
    public void aggiungiComponente(ComponenteNave elemento) {
    	getComponenti().add(elemento);
    }
     /**
     * Aggiunge un componente alla griglia e alla lista.
     *
     * @param elemento il componente da aggiungere
     * @param x posizione x nella griglia
     * @param y posizione y nella griglia
     */
    public void aggiungiComponente(ComponenteNave elemento, int x, int y) {
    	griglia[x][y] = elemento;
    	this.componenti.add(elemento);
    }
     /**
     * Conta quanti cannoni attivi ci sono sulla nave.
     *
     * @return numero di cannoni attivi
     */

    public int contaCannoniAttivi() {
        int count = 0;
        for (ComponenteNave componente : componenti) {
            if (componente instanceof Cannone) {
                count++;
            }
        }
        return count;
    }
     /**
     * Aggiunge un cannone alla nave.
     *
     * @param cannone il cannone da aggiungere
     */
    public void aggiungiCannone(Cannone cannone) {
        componenti.add(cannone);
    }
     /**
     * Rimuove un cannone dalla nave, se presente.
     */
    public void rimuoviCannone() {
        for (ComponenteNave componente : componenti) {
            if (componente instanceof Cannone) {
                componenti.remove(componente);
                return; 
            }
        }
    }
     /**
     * Riduce il numero di armi attive in base all’intensità dell’evento.
     *
     * @param intensitaEvento quanto ridurre le armi
     */
    public void disabilitaArmi(int intensitaEvento) {
    	armiAttive = armiAttive - intensitaEvento;
        if (armiAttive < 0) {
        	armiAttive = 0; 
        }
    }
     /**
     * Restituisce una descrizione testuale dello stato della nave.
     *
     * @return stringa con le informazioni principali della nave
     */
    
    public String toString() {
    	return "Nave {\n" + "Vita: " + getVita() + "; Scudi attivi: " + getScudiAttivi() + "; Energia disponibile: " + getEnergiaDisponibile() + "; Componenti: " + getComponenti() + "\n}"; 
    }
    
}
