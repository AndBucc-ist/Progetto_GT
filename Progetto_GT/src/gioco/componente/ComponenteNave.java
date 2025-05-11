package gioco.componente;

import gioco.Orientamento;
import gioco.TipoConnettore;

public abstract class ComponenteNave {
	
	private int id;
	private int posizioneX;
	private int posizioneY;
	private Orientamento direzione;
	private TipoConnettore tipoConnettore;
	
	public ComponenteNave() {
	}
	
	public ComponenteNave(int id) {
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setX(int x) {
		this.posizioneX = x;
	}
	
	public void setY(int y) {
		this.posizioneY = y;
	}
	
	public int getX() {
		return posizioneX;
	}
	
	public int getY() {
		return posizioneY;
	}
	
	public TipoConnettore getTipoConnettore() {
		return this.tipoConnettore;
	}
	
	public void setTipoConnettore(TipoConnettore tipoConnettore) {
		this.tipoConnettore = tipoConnettore;
	}
	
	public void setOrientamento(Orientamento elemento) {
		direzione = elemento;
	}
	
	public Orientamento getOrientamento() {
		return direzione;
	}

	public String toString() {
		return "Componente{ x: " + getX() + "; y: " + getY() + "; orientamento: " + getOrientamento() + "; tipo di connettore: " + getTipoConnettore() + " }\n";
	}

}
