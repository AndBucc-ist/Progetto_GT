package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class Laser extends ComponenteNave{
    private int danno;

    public Laser(int id ,int danno, Orientamento direzione, TipoConnettore tipoConnettore) {
        super(id);
        this.danno = danno;
        setOrientamento(direzione);
        setTipoConnettore(tipoConnettore);
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
    
    public boolean puòSparare(boolean energiaDisponibile) {
    	if(energiaDisponibile) {
    		return true;
    	}
    	return false;
    }
}
