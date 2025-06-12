package gioco;

import java.util.Random;

/**
 * Enum che rappresenta i tipi di connettore possibili
 * per i componenti di una nave.
 */
public enum TipoConnettore {
    /** Connettore semplice */
    SEMPLICE,
    /** Connettore doppio */
    DOPPIO,
    /** Connettore universale (si adatta a tutto) */
    UNIVERSALE,
    /** Nessun connettore presente */
    NESSUNO;

    /**
     * Restituisce un tipo di connettore scelto casualmente.
     *
     * @return un tipo casuale tra SEMPLICE, DOPPIO, UNIVERSALE, NESSUNO
     */
    public static TipoConnettore connettoreCasuale() {
        Random rand = new Random();
        int h = rand.nextInt(4) + 1;

        switch(h) {
            case 1: return TipoConnettore.SEMPLICE;
            case 2: return TipoConnettore.DOPPIO;
            case 3: return TipoConnettore.UNIVERSALE;
            case 4: return TipoConnettore.NESSUNO;
            default: return TipoConnettore.NESSUNO;	
        }
    }
}
