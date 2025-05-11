package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class Motore extends ComponenteNave{
	private int spinta;
    private boolean usaEnergia;

    public Motore(int id, Orientamento direzione, TipoConnettore tipoConnettore ,int spinta, boolean usaEnergia) {
    	super(id);
		setOrientamento(direzione);
		setTipoConnettore(tipoConnettore);
    	this.spinta = spinta;
        this.usaEnergia = usaEnergia;
    }

    public int getSpinta() {
        return spinta;
    }

    public boolean richiedeEnergia() {
        return usaEnergia;
    }
}
