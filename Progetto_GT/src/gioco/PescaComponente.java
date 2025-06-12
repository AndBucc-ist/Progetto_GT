package gioco;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import gioco.componente.ComponenteNave.TipoComponente;
import gioco.componente.ComponenteNave;
/**
 * Classe che gestisce la pesca casuale dei componenti della nave.
 * Tiene traccia di quanti componenti di ogni tipo sono disponibili
 * e genera ID unici per ogni componente pescato.
 */
public class PescaComponente {
	
	    private Map<TipoComponente, Integer> pesca = new HashMap<>();
	    private Set<Integer> usedIds = new HashSet<>();
	
	    /**
    	    * Costruttore che inizializza la disponibilità di ogni tipo di componente a 10.
            */

	    public PescaComponente() {
	        for (TipoComponente tipo : TipoComponente.values()) {
	        	pesca.put(tipo, 10); 
	        }
	    }
	     /**
	     * Pesca un componente casuale tra quelli disponibili.
	     * 
	     * @return un nuovo componente con tipo casuale e ID univoco,
	     *         oppure null se non ci sono più componenti disponibili.
	     */
	    public ComponenteNave pescaComponenteCasuale() {
	    	int randomId;
	        List<TipoComponente> disponibile = new ArrayList<>();
	        for (var entry : pesca.entrySet()) {
	            if (entry.getValue() > 0) {
	            	disponibile.add(entry.getKey());
	            }
	        }

	        if (disponibile.isEmpty()) return null;

	        TipoComponente scelta = disponibile.get(new Random().nextInt(disponibile.size()));
	        pesca.put(scelta, pesca.get(scelta) - 1);
	        
	        do {
	            randomId = ThreadLocalRandom.current().nextInt(1000, 10000);
	        } while (usedIds.contains(randomId));
	        usedIds.add(randomId);
	        
	      
	        return new ComponenteNave(scelta,randomId);
	        
	    }
	     /**
	     * Restituisce un componente al mazzo, incrementando la sua disponibilità.
	     * 
	     * @param componente il componente da restituire
	     */
	    public void returnComponente(ComponenteNave componente) {
	        TipoComponente tipo = componente.getTipo();
	        pesca.put(tipo, pesca.getOrDefault(tipo, 0) + 1);
	    }
	     /**
	     * Stampa sul terminale la quantità disponibile di ogni tipo di componente.
	     */
	    public void printaDisponibile() {
	        for (var entry : pesca.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	}


