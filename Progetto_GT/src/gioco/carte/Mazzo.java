package gioco.carte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import gioco.tipo.TipoBonus;
import gioco.tipo.TipoEventoSpeciale;
import gioco.tipo.TipoMerce;

public class Mazzo {
	
	private ArrayList<CartaAvventura> mazzoCarte;
	
	public Mazzo() {
		
		mazzoCarte = new ArrayList<>();
		
	}

	
	public void caricaCarte() {
		String nomeFile = "listaCarte.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))){
			String linea;
			br.readLine(); 
			
			while((linea = br.readLine()) != null) {
				String[] valore = linea.split(";");  
				
				String nome = valore[0];
				String descrizione = valore[1];
				int prioritaDiEsecuzione = Integer.parseInt(valore[2]);
				String tipoCarta = valore[3];
				String direzione = valore[4];
				
				try{
					switch(tipoCarta) {
						case "CartaEventoGenerico": 
							int danno = Integer.parseInt(valore[5]);
							mazzoCarte.add(new CartaEventoGenerico(nome, descrizione, prioritaDiEsecuzione, danno, direzione));
							break;
							
						case "CartaPirati":	
							int potenzaPirati = Integer.parseInt(valore[5]);
	                        int ricompensa = Integer.parseInt(valore[6]);
	                        mazzoCarte.add(new CartaPirati(nome, descrizione, prioritaDiEsecuzione, potenzaPirati, ricompensa, direzione));
	                        break;
					
						case "CartaMercato":
							Map<TipoMerce, Integer> prezziAcquisto = new HashMap<>();
						    Map<TipoMerce, Integer> prezziVendita = new HashMap<>();
						    
						    //Il formato nel txt dovrebbe essere tipo: (acquisto) NORMALE|10, ESOTICA|40; (vendita)  NORMALE|5, PERICOLOSA|100
						    
						    String[] acquistoArray = valore[5].split("\\|"); 
						    for (String elemento : acquistoArray) {
						        String[] parti = elemento.split(",");
						        TipoMerce tipo = TipoMerce.valueOf(parti[0]);
						        int prezzo = Integer.parseInt(parti[1]);
						        prezziAcquisto.put(tipo, prezzo);
						    }
						    
						    String[] venditaArray = valore[6].split("\\|");
						    for (String elemento : venditaArray) {
						        String[] parti = elemento.split(",");
						        TipoMerce tipo = TipoMerce.valueOf(parti[0]);
						        int prezzo = Integer.parseInt(parti[1]);
						        prezziVendita.put(tipo, prezzo);
						    }
						    
						    mazzoCarte.add(new CartaMercato(nome, descrizione, prioritaDiEsecuzione, direzione, prezziAcquisto, prezziVendita));
						    break;
							
						case "CartaEventoSpeciale":
							TipoEventoSpeciale tipoEvento = TipoEventoSpeciale.valueOf(valore[5]);
							int intensitaEvento = Integer.parseInt(valore[6]);
							mazzoCarte.add(new CartaEventoSpeciale(nome, descrizione, prioritaDiEsecuzione, direzione, tipoEvento, intensitaEvento));
							break;
						
						case "CartaBonus":
							TipoBonus bonus = TipoBonus.valueOf(valore[5]);
							int quantitaBonus = Integer.parseInt(valore[6]);
							mazzoCarte.add(new CartaBonus(nome, descrizione, prioritaDiEsecuzione, direzione, bonus, quantitaBonus));
							break;
							
						default:
							System.out.println("Tipo della carta non presente");
					}
				}catch(Exception h){
					h.printStackTrace();
				}
			
			}
			
		}catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore durante la creazione della carta: " + e.getMessage());
        }
	}
	
	
	public void mischiaMazzo() {
		Collections.shuffle(this.mazzoCarte);
	}
	
	public CartaAvventura prendiCarta() {
		Random rand = new Random();
		int massimo = rand.nextInt(mazzoCarte.size());
		
		return mazzoCarte.get(massimo);
		
	}
	
}
