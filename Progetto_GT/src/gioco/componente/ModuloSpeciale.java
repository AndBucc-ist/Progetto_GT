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
        // Se volessimo potremmo aggiungere delle logiche diverse (con uno switch case) per ogni effetto
    }

    public String getTipoEffetto() {
        return tipoEffetto;
    }
}
