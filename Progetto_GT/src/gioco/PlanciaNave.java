package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;
import gioco.errori.PosizioneSbagliataException;

/**
 * Rappresenta la plancia di costruzione di una nave nel gioco.
 * Gestisce la posizione di partenza, il punteggio, la griglia con i componenti
 * e fornisce metodi per la validazione e il posizionamento dei componenti sulla nave.
 * 
 * Ogni plancia contiene una griglia 10x10 di {@link ComponenteNave} e una {@link Nave}
 * composta da più componenti con orientamenti e connettori.
 * 
 * @author  
 * @version 1.0
 */

public class PlanciaNave {

	private Nave nave; 
	private int posizionePartenza;
	private int punteggioNave;
	private ComponenteNave[][] griglia = new ComponenteNave[10][10];
	 
    /**
     * Costruisce una nuova plancia di nave con una posizione di partenza specificata.
     * Se la posizione non è valida, viene impostata a 0 e stampato un messaggio di errore.
     *
     * @param posizionePartenza la posizione iniziale della nave
     */
	
	public PlanciaNave(int posizionePartenza) {
		this.nave = new Nave(new ArrayList<ComponenteNave>());
				
		
		try {
			setPosizionePartenza(posizionePartenza);
		} catch (PosizioneSbagliataException e) {
	        System.err.println("Posizione di partenza errata: " + e.getMessage());
	        this.posizionePartenza = 0; 
	    }
		
		this.punteggioNave = 0;
	}
	
	/**
     * Imposta la nave sulla plancia.
     *
     * @param nave la nave da impostare
     */
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	/**
     * Verifica se la plancia è valida, ovvero se tutti i componenti sono
     * correttamente collegati tra loro in base a orientamenti e connettori.
     *
     * @return true se la plancia è valida, false altrimenti
     */
	public boolean planciaValida(){
		
		boolean unValido = false;
		
		
		for(ComponenteNave h: nave.getComponenti()) {
			int X = h.getX();
			int Y = h.getY();
			
			switch(h.getOrientamento()) {
			
			case NORD: Y = Y - 1; break;
				
			case SUD: Y = Y + 1; break;
			
			case EST: X = X + 1; break;
			
			case OVEST: X = X - 1; break;
			} 
			
			
			ComponenteNave n2 = trovaComponente(X, Y);
			if(n2 == null) {
				unValido = false;
			}else {
				
				Orientamento opposto = direzioneOpposta(h.getOrientamento());
				if(n2.getOrientamento() != opposto) { 
					unValido = false;
				}else {
					
					if(!connettoriCompatibili(h.getTipoConnettore(), n2.getTipoConnettore())){
						unValido = false;
					}else {
						setAggiungiInPunteggioNave(1);
						unValido = true;
					
					}
					
				}
				
			}
			
		}
		return unValido;
		
	}
	
    /**
     * Tenta di piazzare un componente in una posizione (x, y) della griglia.
     * 
     * @param x coordinata orizzontale (0-9)
     * @param y coordinata verticale (0-9)
     * @param c componente da piazzare
     * @return true se il piazzamento ha successo, false altrimenti
     */
	public boolean piazzaComponente(int x, int y, ComponenteNave c) {
		if (x >= 0 && x < 10 && y >= 0 && y < 10) {
            griglia[x][y] = c;
            nave.aggiungiComponente(c, x, y);
            
            return true;
        } 
		if (!planciaValida()){
			System.out.println("Componente non compatibile.");
			return false;
		}
		else {
            System.out.println("Posizione non valida.");
            return false;
	}
	}
	
    /**
     * Restituisce il componente presente nella posizione (x, y) della griglia.
     *
     * @param x coordinata orizzontale
     * @param y coordinata verticale
     * @return il componente in quella posizione, oppure null se vuota o fuori griglia
     */
	public ComponenteNave getComponente(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 10) {
            return griglia[x][y];
        }
        return null;
    }

		
    /**
     * Aggiunge un certo numero di punti al punteggio della nave.
     *
     * @param punti i punti da aggiungere
     */
	private ComponenteNave trovaComponente(int x, int y) {
        for (ComponenteNave c : nave.getComponenti()) {
            if (c.getX() == x && c.getY() == y) { 
            	return c;
            	}
        }
        return null;
    }

    /**
     * Imposta il punteggio della nave.
     *
     * @param punti il punteggio da impostare
     */
    private Orientamento direzioneOpposta(Orientamento elemento){
        switch (elemento) {
            case NORD: return Orientamento.SUD;
            case SUD: return Orientamento.NORD;
            case EST: return Orientamento.OVEST;
            case OVEST: return Orientamento.EST;
            default: throw new IllegalArgumentException("Orientamento non valido: " + elemento);
        }
    }
    
    /** 
     * Verifica se due connettori sono compatibili.
     * I connettori sono compatibili se:
     * sono uguali, oppure
     * almeno uno dei due è UNIVERSALE
     * Nessuno dei due deve essere NESSUNO.
     * @param a primo connettore
     * @param b secondo connettore
     * @return true se compatibili, false altrimenti
     */
    public boolean connettoriCompatibili(TipoConnettore a, TipoConnettore b) {
        if (a == TipoConnettore.NESSUNO || b == TipoConnettore.NESSUNO) {
        	return false;
        } 
        return a == b || a == TipoConnettore.UNIVERSALE || b == TipoConnettore.UNIVERSALE;
    }

    /**
     * Aggiunge un numero di punti al punteggio della nave.
     *
     * @param punti i punti da aggiungere
     */
	public void setAggiungiInPunteggioNave(int punti) {
		punteggioNave = punteggioNave + punti;
	}
	
	public void setPunteggioNave(int punti) {
		this.punteggioNave = punteggioNave;
	}
	
	public int getPunteggioNave() {
		return punteggioNave;
	}
	
	public int getPosizionePartenza() {
		return posizionePartenza;
	}

	public void setPosizionePartenza(int posizionePartenza)throws PosizioneSbagliataException {
		if(posizionePartenza < 0) {
			throw new PosizioneSbagliataException("Posizione non valida!");
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
