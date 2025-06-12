package gioco;

import java.util.Random;

/**
 * Enum che rappresenta i quattro orientamenti possibili.
 */
public enum Orientamento {
    /** Direzione Nord */
    NORD,
    /** Direzione Sud */
    SUD,
    /** Direzione Est */
    EST,
    /** Direzione Ovest */
    OVEST;

    /**
     * Restituisce un orientamento scelto casualmente tra NORD, SUD, EST e OVEST.
     *
     * @return un orientamento casuale
     */
    public static Orientamento orientamentoCasuale() {
        Random rand = new Random();
        int h = rand.nextInt(4) + 1;

        switch(h) {
            case 1: return Orientamento.NORD;
            case 2: return Orientamento.SUD;
            case 3: return Orientamento.EST;
            case 4: return Orientamento.OVEST;
            default: return Orientamento.NORD;
        }
    }
}

