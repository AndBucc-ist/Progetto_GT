package gioco.componente;

import gioco.Orientamento;

public class Batteria extends ComponenteNave {

	private int energiaMassima;
	private int energiaAttuale;
	
	public Batteria(int id, Orientamento direzione, int energiaMassima) {
		super(id);
		this.energiaMassima = energiaMassima;
		this.energiaAttuale = energiaMassima;
		setOrientamento(direzione);
	}
	

	public int getEnergiaMassima() {
		return energiaMassima;
	}

	public void setEnergiaMassima(int energiaMassima) {
		this.energiaMassima = energiaMassima;
	}

	public int getEnergiaAttuale() {
		return energiaAttuale;
	}

	public void setEnergiaAttuale(int energiaAttuale) {
		this.energiaAttuale = energiaAttuale;
	}
	
	
	public void consumaEnergia(int energiaConsumata) {
		if(energiaConsumata > getEnergiaAttuale()) {
			int energia = getEnergiaAttuale() - energiaConsumata;
			setEnergiaAttuale(energia);
		}else {
			setEnergiaAttuale(0);
		}
				
	}
	
	public void ricaricaEnergia(int energia) {
		setEnergiaAttuale(energia);
	}
	
	public boolean haEnergia() {
        return getEnergiaAttuale() > 0;
    }
	
}
