package gioco.componente;

import java.util.EnumMap;
import gioco.Orientamento;
import gioco.TipoConnettore;

public abstract class ComponenteNave {
	
	private int id;
	private int posizioneX;
	private int posizioneY;
	private Orientamento direzione;
	private EnumMap<Orientamento, TipoConnettore> lati;
	
	public ComponenteNave() { // ?? costruttore??
	}
	
	public ComponenteNave(int id) {
		this.id=id;
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
	
	
	public void setOrientamento(Orientamento elemento) {
		direzione = elemento;
	}
	
	public Orientamento getOrientamento() {
		return direzione;
	}
	
	// INIZIO: aggiungo sezioni sul connettore - primo tentativo 
	
	public void setConnettore(Orientamento direzione, TipoConnettore connettore) {
		lati.put(direzione, connettore);
	}
	
	
	public TipoConnettore getConnettoreReale(Orientamento altra_direzione) { // ottieni la "vera" direzione della componente vicina.direzione = la direzione dell'altro componente verso cui siamo interessati
		
		int offset = (altra_direzione.ordinal() - direzione.ordinal() + 4) % 4;
	    Orientamento relativeDir = Orientamento.values()[offset];
	    return lati.getOrDefault(relativeDir, TipoConnettore.NONE);
	}
	
	public boolean ConnessioneConnettore(ComponenteNave altro, Orientamento direzione_vicino) { // check per compatibilità fra connettori vicini
	    TipoConnettore Connettore = this.getConnettoreReale(direzione_vicino);
	    TipoConnettore altroConnettore = altro.getConnettoreReale(direzione_vicino.inverti());
	    return Connettore.isCompatibile(altroConnettore);
	}

	
	//FINE

	public String toString() {
		return "Componente{ x: " + getX() + "; y: " + getY() + "; orientamento: " + getOrientamento() + " }\n";
	}

}
