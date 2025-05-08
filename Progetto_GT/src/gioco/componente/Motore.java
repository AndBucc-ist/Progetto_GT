package gioco.componente;

import gioco.Orientamento;

public class Motore extends ComponenteNave{
	private int spinta;
    private boolean usaEnergia;

    public Motore(int id, Orientamento direzione, int spinta, boolean usaEnergia) {
    	super(id);
		setOrientamento(direzione);
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
