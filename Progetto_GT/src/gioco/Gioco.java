package gioco;

import java.nio.channels.Pipe.SourceChannel;

import java.util.ArrayList;
import java.util.Scanner;

import gioco.carte.CartaAvventura;
import gioco.carte.Mazzo;
import gioco.componente.ComponenteNave;
import gioco.errori.NomeDuplicatoException;
import gioco.errori.PosizioneSbagliataException;
import gioco.PlanciaNave;
import gioco.Nave;
import gioco.PescaComponente;


public class Gioco {

	private Mazzo mazzoCarte;
	private ArrayList<PlanciaNave> plancia = new ArrayList<>();
	private PescaComponente pesca = new PescaComponente();
	private ArrayList <Giocatore> listaGiocatori=new ArrayList<>();

	
	public Gioco() {}
	
	public void iniziaPartita() throws Exception{
		Scanner scanner= new Scanner(System.in);
		int numGiocatori=0;
		int pos;
		int pos2;
		String nome;
		boolean fineTurno = false;
		boolean fineWhile = true;
		
		System.out.println("GALAXY TRUCKER");
	    System.out.println("Partita livello 1 (default)");
		
	    while(fineWhile) {
	    	pos=0;
			pos2 = 1;
	    	try {
			
			    do{
					System.out.println("In quanti volete giocare? (max 4)");
					numGiocatori=scanner.nextInt();
					scanner.nextLine();
					if(numGiocatori<2||numGiocatori>4){
						System.out.println("numero di giocatori non disponibile\n");
					}else{
						System.out.println("Giocatori selezionati: "+numGiocatori+"\n");
						break;
					}
				}
				while(true);
					
				
				while(numGiocatori>0){
					PlanciaNave plancia = new PlanciaNave(pos2++);
					System.out.println("Menu aggiunta giocatore "+ ++pos + ":");
					System.out.println("Inserisci il nome del Giocatore "+pos+": ");
					nome=scanner.nextLine();
					Giocatore giocatore= new Giocatore(nome, plancia);
					System.out.println("Giocatore creato correttamente\n");
					listaGiocatori.add(giocatore);
		
					
					numGiocatori--;
				}
			    
			    
			    
			    mazzoCarte = new Mazzo();
				mazzoCarte.caricaCarte();
				mazzoCarte.mischiaMazzo();
				
				System.out.println("Mazzo creato!\n");
				
				System.out.println("Creazione della nave\n");
				
		        for(Giocatore h: listaGiocatori) {
		        	System.out.println("Questo è il turno di " + h.getNome());
		        	int x = 0;
	        		int y = 0;
	        		
		        	while(x >-1 && y >-1 ) {
	
		        	fineTurno = false;
		        	while (!fineTurno) {
			        	
			        	ComponenteNave componenteRandom = pesca.pescaComponenteCasuale();
	
			            if (componenteRandom == null) {
			                System.out.println("\nNiente più componenti!");
			                break;
			            }
	
			            System.out.println("\nHai pescato: " + componenteRandom.getTipo());
	
			            System.out.print("Inserire le coordinate x ed y (minori di 0 per scartare): ");
			            x = scanner.nextInt();
			            scanner.nextLine();
			            y = scanner.nextInt();
			            scanner.nextLine();
	
			            if (x <= -1 || y <= -1) {
			                pesca.returnComponente(componenteRandom);
			                System.out.println("fine del turno di " + h.getNome() + ".\n");
			                fineTurno = true;
			                break;
			            }
			            
			            if(x>10 || y>10) {
			                System.out.println("Coordinate non valide!\n");
			                continue;}
			            
			                else {
			                	
	
			            
			            componenteRandom.setX(x);
			            componenteRandom.setY(y);
			            componenteRandom.setOrientamento(Orientamento.orientamentoCasuale());
			            componenteRandom.setTipoConnettore(TipoConnettore.connettoreCasuale());
			            
			            h.getPlancia().piazzaComponente(x, y, componenteRandom);
				        System.out.println("Componente piazzata!");
				        fineTurno = true;
			            }
			        }
		        	}
		        }
				
		        System.out.println("Componenti presenti: \n");
		        
		        for(Giocatore k: listaGiocatori) {
		        	System.out.println("Giocatore " + k.getNome() + " --> " + k.getPlancia().toString()+"\n");
		        }
		        
		        
		        int h = 7;
		        
		        while(h>0) {
		        	h--;
		        
			        System.out.println("Carta pescata: ");
			        
			        CartaAvventura cartaPescata =  mazzoCarte.prendiCarta();
			        String nomeCartaPescata =  mazzoCarte.prendiCarta().getNome();
			        System.out.println(cartaPescata.toString()+"\n");
		        
		        
			        for(Giocatore giocatore: listaGiocatori) {
			        
			        	System.out.println("Applica effetto carta al giocatore " + giocatore.getNome() + "\n");
			        	
			        	switch (nomeCartaPescata) {
				        	case "PioggiaMeteoriti":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "AssaltoPirati":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "MercatoSpaziale":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "TempestaSolare":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "BucoNeroVicino":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "CampoMinatoSpaziale":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "BonusCarico":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	case "MercatoPericoloso":
				        		cartaPescata.applicaEffetto(giocatore);
				        		break;
				        		
				        	default: break;	
			        	}
			        	System.out.println("\n--- Stato attuale delle navi ---");
			        	for (Giocatore g : listaGiocatori) {
			        	    System.out.println("Giocatore: " + g.getNome());
			        	    System.out.println(g.getPlancia().toString());
			        	    System.out.println("Vita nave: " + g.getPlancia().getNave().getVita());
			        	    System.out.println("--------------------------------");
			        	}
			        	
			        	System.out.println("Premi INVIO per continuare al prossimo turno...");
			        	scanner.nextLine();
			        	 System.out.println("\n\n");
					        System.out.println("----------------------------------------------------------------------------------");
			        }
				        	boolean tuttiMorti = true;
				        	ArrayList<Giocatore> giocatoriVivi = new ArrayList<>();

				        	for (Giocatore g : listaGiocatori) {
				        	    if (g.getPlancia().getNave().getVita() > 0) {
				        	        tuttiMorti = false;
				        	        giocatoriVivi.add(g);
				        	    }
				        	

				        	if (tuttiMorti) {
				        	    System.out.println("Hai perso. Tutti i giocatori sono morti.");
				        	    return;
				        	} 
				        	    
				        	 
				        	}

			        	}
		        System.out.println("Hai vinto! Giocatori rimasti in vita:");
		        for (Giocatore g : listaGiocatori) {
		            if (g.getPlancia().getNave().getVita() > 0) {
		                System.out.println("- " + g.getNome() + " (Vita: " + g.getPlancia().getNave().getVita() + ")");
		            }
		        }
	
		        
		        
		        fineWhile = false;
				
			}catch(IndexOutOfBoundsException h){ 
				h.printStackTrace();
			}catch(NomeDuplicatoException s) {
				System.out.println(s.getMessage() + "\n"); 
			}catch(PosizioneSbagliataException b) {
				System.out.println(b.getMessage() + "\n");
			}
		
	    }
	        
	    scanner.close();
	}
}

	   

