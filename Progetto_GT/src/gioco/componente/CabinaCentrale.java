package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class CabinaCentrale extends ComponenteNave{

	private final int equipaggioMax = 2;
	private int equipaggioAttuale;

	public CabinaCentrale(int id, Orientamento direzione, TipoConnettore tipoConnettore) {
		super(id);
		setOrientamento(direzione);
		setTipoConnettore(tipoConnettore);
	}
	
	public boolean aggiungiMembro() {
        if (equipaggioAttuale < equipaggioMax) {
            equipaggioAttuale++;
            return true;
        }
        return false;
    }

    public boolean rimuoviMembro() {
        if (equipaggioAttuale > 0) {
            equipaggioAttuale--;
            return true;
        }
        return false;
    }

    public int getEquipaggioAttuale() {
        return equipaggioAttuale;
    }

    public boolean èVuota() {
        return equipaggioAttuale == 0;
    }
	
}
