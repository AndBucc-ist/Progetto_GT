package gioco;

import java.util.ArrayList;
import java.util.Scanner;

import gioco.carte.Mazzo;
import gioco.componente.ComponenteNave;
import gioco.PlanciaNave;
import gioco.Nave;
import gioco.PescaComponente;


public class Gioco {

	private Mazzo mazzoCarte;
	//private Nave nave = new Nave(new ArrayList<ComponenteNave>());
	private ArrayList<PlanciaNave> plancia = new ArrayList<>(); //posizione = 0, nave = null va bene? ci sarà un setter dopo.
	private PescaComponente pesca = new PescaComponente();
	private ArrayList <Giocatore> listaGiocatori=new ArrayList<>();

	
	public Gioco() {}
	
	public ArrayList<ComponenteNave> generaComponenti(){ //ci serve??
		//Qua possiamo far generare la quantità di componenti anche in maniera casuale.
		return null;
	}
	
	public void iniziaPartita() {
		Scanner scanner= new Scanner(System.in);
		int numGiocatori=0;
		int pos=0;
		int pos2 = 1;
		String nome;
		boolean fineTurno = false;
		
		
		try {
			
			System.out.println("GALAXY TRUCKER");
		    System.out.println("Partita livello 1 (default)");
			
			
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
			
			System.out.println("Mazzo creato!");
			
			System.out.println("Creazione della nave\n");
			//L'unico valore che deve essere generato è la lista dei componenti
			//Possiamo generarla in maniera casuale e mostrare all'utente i componenti che avrà nella navicella poi passiamo la lista nel costruttore
			
			
	        for(Giocatore h: listaGiocatori) {
	        
	        	int x = 0;
        		int y = 0;
        		
	        	while(x >-1 && y >-1 ) {

	        	fineTurno = false;
	        	while (!fineTurno) {
		        	
		        	ComponenteNave componenteRandom = pesca.pescaComponenteCasuale();

		            if (componenteRandom == null) {
		                System.out.println("Niente più componenti!");
		                break;
		            }

		            System.out.println("Hai pescato: " + componenteRandom.getTipo());

		            System.out.print("Inserire le coordinate x ed y (-1 e -1 per scartare): ");
		            x = scanner.nextInt();
		            scanner.nextLine();
		            y = scanner.nextInt();
		            scanner.nextLine();

		            if (x == -1 && y == -1) {
		                pesca.returnComponente(componenteRandom);
		                System.out.println("fine turno.");
		                fineTurno = true;
		                continue;
		            }

		            if (h.getPlancia().piazzaComponente(x, y, componenteRandom)) {
		                System.out.println("Componente piazzata!");
		                fineTurno = true;
		            } else {
		                System.out.println("Piazzamento errato. Riprova");
		                pesca.returnComponente(componenteRandom);
		            }
		        }
	        	}
	        }
			
			
	        
	        System.out.println("Componenti presenti: ");
	        
	        for(Giocatore k: listaGiocatori) {
	        	System.out.println(k.getPlancia().toString());
	        }
	        
	        
			
		}catch(Exception h){ //Dobbiamo mettere l'Exception specifica (magari con più catch)
			h.printStackTrace();
		}
	
	
	        
	}
}

	   

