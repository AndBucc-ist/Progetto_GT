package gioco.componente;

import gioco.Orientamento;

public class ModuloCarica extends ComponenteNave{
	private int capacitaMassima;
    private int merceAttuale;

    public ModuloCarica(int id ,int danno, Orientamento direzione, int capacitaMassima) {
    	super(id);
        setOrientamento(direzione);
        this.capacitaMassima = capacitaMassima;
    }

    public boolean aggiungiMerce(int quantita) {
        if (merceAttuale + quantita <= capacitaMassima) {
            merceAttuale = merceAttuale + quantita;
            return true;
        }
        return false;
    }

    public int scarica() {
        int merce = merceAttuale;
        merceAttuale = 0;
        return merce;
    }

    public int getMerceAttuale() {
        return merceAttuale;
    }
}
