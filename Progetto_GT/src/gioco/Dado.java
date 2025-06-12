package gioco;

import java.util.Random;
/**
 * Rappresenta un dado con 6 facce.
 * Può essere lanciato per ottenere un numero casuale da 1 a 6.
 */
public class Dado {

	private final int facce;
	private Random random;
     /**
     * Costruttore della classe Dado.
     * Crea un dado a 6 facce.
     */
	public Dado() {
		this.facce = 6;
		random = new Random();
	}
	
     /**
     * Lancia il dado e restituisce un numero casuale da 1 a 6.
     *
     * @return un numero intero compreso tra 1 e 6
     */
	public int lanciaDado() {
		return random.nextInt(this.facce) + 1;
	}
	
	
}
