package gioco;

import java.util.ArrayList;

import gioco.componente.ComponenteNave;

public class Nave {

	private int vita; 
    private ArrayList<ComponenteNave> componenti;
    private int scudiAttivi;
    private int energiaDisponibile;
    private boolean motoreAttivo;
 
    public Nave(ArrayList<ComponenteNave> componenti) {
        this.componenti = new ArrayList<>(componenti);
        this.vita = 100; 
        this.scudiAttivi = 0;
        this.energiaDisponibile = 10;
        this.motoreAttivo = true;
    }
    
    public void dannoSubito(int danno) {
    	int valore = getVita() - danno;
    	
    	if(valore>0) {
    		setVita(danno);
    	}else {
    		setVita(0);
    	}
    }
    
   
    public boolean Distrutta() {
    	return getVita() <= 0;
    }

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
    
    public void aggiungiComponente(ComponenteNave elemento) {
    	getComponenti().add(elemento);
    }

    public String toString() {
    	return "Nave {\n" + "Vita: " + getVita() + "; Scudi attivi: " + getScudiAttivi() + "; Energia disponibile: " + getEnergiaDisponibile() + "; Componenti: " + getComponenti() + "\n}"; 
    }
    
}
