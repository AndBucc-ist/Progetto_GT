package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class Cannone extends ComponenteNave {
    private int potenzaFuoco;

    public Cannone(int id ,int potenzaFuoco, Orientamento direzione, TipoConnettore tipoConnettore) {
        super(id);
        this.potenzaFuoco = potenzaFuoco;
        setOrientamento(direzione);
        setTipoConnettore(tipoConnettore);
    }

    public int getPotenzaFuoco() {
        return potenzaFuoco;
    }

    public void setPotenzaFuoco(int potenzaFuoco) {
        this.potenzaFuoco = potenzaFuoco;
    }

    public boolean puòSparare(boolean energiaDisponibile) {
    	if(energiaDisponibile) {
    		return true;
    	}
    	return false;
    }
    
    public String toString() {
        return "Cannone { id: " + getId() + "; potenza: " + getPotenzaFuoco() + "; " + super.toString() + " }";
    }
}
