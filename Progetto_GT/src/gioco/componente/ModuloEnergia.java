package gioco.componente;

import gioco.Orientamento;

public class ModuloEnergia extends ComponenteNave{
	private int energiaGenerata;

    public ModuloEnergia(int energia, int id ,int danno, Orientamento direzione) {
    	super(id);
        setOrientamento(direzione);
    	this.energiaGenerata = energia;
    }

    public int getEnergiaGenerata() {
        return energiaGenerata;
    }

    public void fornisciEnergia(Batteria batteria) {
        //Cosi aggiungo energia senza superare il massimo
        int spazio = batteria.getEnergiaMassima() - batteria.getEnergiaAttuale();
        int energiaDaAggiungere = Math.min(spazio, this.energiaGenerata); //prendo il più piccolo cos' mi assicuro di nona ggiugnere più energia del dovuto
        batteria.ricaricaEnergia(energiaDaAggiungere); 
    }
}
