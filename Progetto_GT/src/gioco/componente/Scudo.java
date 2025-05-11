package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class Scudo extends ComponenteNave{
	private int potenza = 1;
    private boolean usaEnergia;

    public Scudo(int id, Orientamento direzione, TipoConnettore tipoConnettore ,boolean usaEnergia) {
    	super(id);
		setOrientamento(direzione);
		setTipoConnettore(tipoConnettore);
    	this.usaEnergia = usaEnergia;
    }

    public int assorbiDanno(int danno, boolean energiaDisponibile) {
        if (getUsaEnergia() && !energiaDisponibile) {
            return danno; //perchè lo scudo è inattivo
        }
        return Math.max(0, danno - getPotenza()); //In questo modo elimino il problema dei valorei negativi e riduco il danno in base alla potenza
    }

    public boolean richiedeEnergia() {
        return usaEnergia;
    }

    public boolean getUsaEnergia() {
    	return this.usaEnergia;
    }
    
    public int getPotenza() {
    	return this.potenza;
    }
    
    public void setPotenza(int potenza) {
    	this.potenza = potenza;
    }
}
