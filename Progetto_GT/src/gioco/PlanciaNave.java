package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;
import gioco.errori.PosizioneSbagliataException;


public class PlanciaNave {

	private Nave nave; 
	private int posizionePartenza;
	private int punteggioNave;
	private ComponenteNave[][] griglia = new ComponenteNave[10][10]; // creazione griglia 10x10 (valore placeholder)
	 
	
	
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
	
	
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	

	
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
	
	public ComponenteNave getComponente(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 10) {
            return griglia[x][y];
        }
        return null;
    }

		

	private ComponenteNave trovaComponente(int x, int y) {
        for (ComponenteNave c : nave.getComponenti()) {
            if (c.getX() == x && c.getY() == y) { 
            	return c;
            	}
        }
        return null;
    }


    private Orientamento direzioneOpposta(Orientamento elemento){
        switch (elemento) {
            case NORD: return Orientamento.SUD;
            case SUD: return Orientamento.NORD;
            case EST: return Orientamento.OVEST;
            case OVEST: return Orientamento.EST;
            default: throw new IllegalArgumentException("Orientamento non valido: " + elemento);
        }
    }

    private boolean connettoriCompatibili(TipoConnettore a, TipoConnettore b) {
        if (a == TipoConnettore.NESSUNO || b == TipoConnettore.NESSUNO) {
        	return false;
        } 
        return a == b || a == TipoConnettore.UNIVERSALE || b == TipoConnettore.UNIVERSALE;
    }

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
