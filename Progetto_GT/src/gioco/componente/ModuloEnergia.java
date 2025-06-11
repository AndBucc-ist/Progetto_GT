package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class ModuloEnergia extends ComponenteNave{
	private int energiaGenerata;

    public ModuloEnergia(int energia, int id ,int danno, Orientamento direzione, TipoConnettore tipoConnettore) {
    	super(id);
        setOrientamento(direzione);
    	this.energiaGenerata = energia;
    	setTipoConnettore(tipoConnettore);
    }

    public int getEnergiaGenerata() {
        return energiaGenerata;
    }

    public void fornisciEnergia(Batteria batteria) {
        int spazio = batteria.getEnergiaMassima() - batteria.getEnergiaAttuale();
        int energiaDaAggiungere = Math.min(spazio, this.energiaGenerata);
        batteria.ricaricaEnergia(energiaDaAggiungere); 
    }
}
