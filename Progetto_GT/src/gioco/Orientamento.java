package gioco;

public enum Orientamento {
	NORD, EST, SUD, OVEST; // importante preservare questo ordine per il metodo getConnettoreReale()
	
	public Orientamento inverti() {
        switch (this) {
            case NORD: return SUD;
            case SUD: return NORD;
            case EST:  return OVEST;
            case OVEST:  return EST;
        }
		return null;
	
	
	}
}
