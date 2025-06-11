package gioco.carte;

import java.util.Map;

import gioco.Giocatore;
import gioco.tipo.TipoMerce;

public class CartaMercato extends CartaAvventura{

	private Map<TipoMerce, Integer> prezziAcquisto;
    private Map<TipoMerce, Integer> prezziVendita;
	
	public CartaMercato(String nome, String descrizione, int prioritaDiEsecuzione, String direzione, Map<TipoMerce, Integer> prezziAcquisto, Map<TipoMerce, Integer> prezziVendita) throws Exception {
		super(nome, descrizione, prioritaDiEsecuzione, direzione);
		this.prezziAcquisto = prezziAcquisto;
		this.prezziVendita = prezziVendita;
	}

	
	public void applicaEffetto(Giocatore giocatore) {		
		int merceDaDare = 2;
        int merceDaRicevere = 1;
        
        
		System.out.println("Effetto Carta Mercato: " + getDescrizione());

        System.out.println("Merci disponibili per l'acquisto: " + prezziAcquisto);
        System.out.println("Merci disponibili per la vendita: " + prezziVendita);

       
        if (giocatore.getMerce() >= merceDaDare) {
            giocatore.rimuoviMerce(merceDaDare);
            giocatore.aggiungiMerce(merceDaRicevere);
            System.out.println("Scambiato " + merceDaDare + " merci per " + merceDaRicevere + " merci");
            
        } else {
            System.out.println("Nessuno scambio possibile perchè le merci sono insufficienti");
        }
	
	}
	
	
	public Map<TipoMerce, Integer> getPrezziAcquisto() {
        return prezziAcquisto;
    }

    public Map<TipoMerce, Integer> getPrezziVendita() {
        return prezziVendita;
    }

    public void setPrezziAcquisto(Map<TipoMerce, Integer> prezziAcquisto) {
        this.prezziAcquisto = prezziAcquisto;
    }

    public void setPrezziVendita(Map<TipoMerce, Integer> prezziVendita) {
        this.prezziVendita = prezziVendita;
    }

}
