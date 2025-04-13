package gioco;

import java.util.Random;

public class Dado {

	private final int facce;
	private Random random;
	
	public Dado() {
		this.facce = 6;
		random = new Random();
	}
	
	
	public int lanciaDado() {
		return random.nextInt(this.facce) + 1;
	}
	
	
}
