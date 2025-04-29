package gioco;

public enum TipoConnettore {
	NONE, SINGOLO, DOPPIO, UNIVERSALE;
	
	public boolean isCompatibile(TipoConnettore altro_lato) {
		switch(this) {
		case SINGOLO: case DOPPIO:
			return this != NONE && this == altro_lato;
		case UNIVERSALE:
			return true;
		case NONE:
			return false;
		}
				
	return false; // non ho trovato il modo di non includerlo senza lancio di errori. Poco elegante.
	}

}
