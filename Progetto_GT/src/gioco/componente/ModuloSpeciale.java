package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public class ModuloSpeciale extends ComponenteNave{
	private String tipoEffetto;

    public ModuloSpeciale(String tipoEffetto, int id, Orientamento direzione, TipoConnettore tipoConnettore) {
        super(id);
		setOrientamento(direzione);
        this.tipoEffetto = tipoEffetto;
        setTipoConnettore(tipoConnettore);
    }

    public void attivaEffetto() {
        System.out.println("Effetto speciale attivato: " + tipoEffetto);
    }

    public String getTipoEffetto() {
        return tipoEffetto;
    }
}
