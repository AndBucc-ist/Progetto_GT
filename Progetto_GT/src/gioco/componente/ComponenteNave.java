package gioco.componente;

import java.util.Random;

import gioco.Orientamento;
import gioco.TipoConnettore;
 /**
 * Rappresenta un componente della nave con un tipo, posizione, orientamento e tipo di connettore.
 */
public  class ComponenteNave {
 /**
 * Enum che definisce i tipi di componenti disponibili per la nave.
 */
public enum TipoComponente {
	    Batteria, CabinaCentrale, CabinaEquipaggio, Cannone, Laser, ModuloCarica,
	    ModuloEnergia, ModuloSpeciale, Motore, Scudo
	}
	
	private int id;
	private TipoComponente Tipo;
	private int posizioneX;
	private int posizioneY;
	private Orientamento direzione;
	private TipoConnettore tipoConnettore;
     /**
     * Costruisce un componente nave con tipo e id specificati.
     * 
     * @param tipo tipo del componente (es. Cannone, Motore)
     * @param id identificativo univoco del componente
     */
	
	public ComponenteNave(TipoComponente tipo, int id) {
		this.id=id;
		this.Tipo = tipo;
		
	}
     /**
     * Costruisce un componente nave con solo id (tipo da impostare successivamente).
     * 
     * @param id identificativo univoco del componente
     */
	public ComponenteNave(int id) {
		this.id=id;
	} 
	
	public TipoComponente getTipo() {
		return Tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public void setTipo(TipoComponente tipo) {
		Tipo = tipo;
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
