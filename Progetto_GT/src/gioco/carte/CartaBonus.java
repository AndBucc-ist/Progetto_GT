package gioco.carte;

import gioco.Giocatore;
import gioco.Orientamento;
import gioco.componente.Cannone;
import gioco.tipo.TipoBonus;

public class CartaBonus extends CartaAvventura{

	private TipoBonus bonus;
    private int quantitaBonus;
	
	public CartaBonus(String nome, String descrizione, int prioritaDiEsecuzione, String direzione, TipoBonus bonus, int quantitaBonus) throws Exception {
		super(nome, descrizione, prioritaDiEsecuzione,direzione);
		this.bonus = bonus;
		this.quantitaBonus = quantitaBonus;
	}

	public void applicaEffetto(Giocatore giocatore) {		
		System.out.println("Effetto Carta Bonus: " + getDescrizione());

        switch (bonus) {
        
            case EQUIPAGGIO:
                giocatore.aumentaEquipaggio(quantitaBonus);
                System.out.println("Aggiunto equipaggio: " + quantitaBonus);
                break;
                
            case CANNONI:
                Cannone nuovoCannone = new Cannone(1, 2, Orientamento.NORD); 
                giocatore.getPlancia().getNave().aggiungiCannone(nuovoCannone);
                System.out.println("Aggiunto cannone");
                break;
                
            case MERCE:
                giocatore.aggiungiMerce(quantitaBonus);
                System.out.println("Aggiunta merce: " + quantitaBonus);
                break;
                
            case CREDITI:
                giocatore.aggiungiCrediti(quantitaBonus);
                System.out.println("Aggiunti crediti: " + quantitaBonus);
                break;
                
            default:
                System.out.println("Tipo di bonus non presente");
        }
	}

	public TipoBonus getBonus() {
        return bonus;
    }

    public int getQuantitaBonus() {
        return quantitaBonus;
    }

    public void setTipoBonus(TipoBonus bonus) {
        this.bonus = bonus;
    }

    public void setQuantitaBonus(int quantitaBonus) {
        this.quantitaBonus = quantitaBonus;
    }

}
