package gioco.carte;

import gioco.Giocatore;
import gioco.tipo.TipoEventoSpeciale;

public class CartaEventoSpeciale extends CartaAvventura{

	 private TipoEventoSpeciale tipoEvento;
	 private int intensitaEvento;
	
	public CartaEventoSpeciale(String nome, String descrizione, int prioritaDiEsecuzione, String direzione, TipoEventoSpeciale tipoEvento, int intensitaEvento) throws Exception {
		super(nome, descrizione, prioritaDiEsecuzione, direzione);
		this.tipoEvento = tipoEvento;
		this.intensitaEvento = intensitaEvento;
	}

	public void applicaEffetto(Giocatore giocatore) {	
		
		System.out.println("Effetto Carta Evento Speciale: " + getDescrizione());

        switch (tipoEvento) {
            case TEMPESTA_SOLARE:
                giocatore.getPlancia().getNave().disabilitaArmi(intensitaEvento); // L'intensitaEvento indica il numero di armi disabilitate
                System.out.println("Tempesta solare! Armi disabilitate");
                break;
                
            case BUCO_NERO:
                giocatore.perdiMercePercentuale(intensitaEvento); // L'intensitaEvento indica la percentuale di merci perse
                System.out.println("Buco nero! Merci perse");
                break;
                
            case CAMPO_MINATO:
                giocatore.getPlancia().getNave().dannoSubito(intensitaEvento); // L'intensitaEvento indica il danno subito
                System.out.println(" Campo minato! Danni subiti");
                break;
                
            default:
                System.out.println("Tipo di evento speciale non esistente");
        }
	}


	public TipoEventoSpeciale getTipoEvento() {
        return tipoEvento;
    }

    public int getIntensitaEvento() {
        return intensitaEvento;
    }

    public void setTipoEvento(TipoEventoSpeciale tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setIntensitaEvento(int intensitaEvento) {
        this.intensitaEvento = intensitaEvento;
    }
	
}
