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
	private Nave nave;
	private PlanciaNave plancia; //posizione = 0, nave = null va bene? ci sarà un setter dopo.
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
		String nome;
		boolean fineTurno = false;
		
		try {
			
			System.out.println("GALAXY TRUCKER");
		    System.out.println("Partita livello 1 (default)");
			
			
		    do{
				System.out.println("In quanti volete giocare? (max 4)");
				numGiocatori=scanner.nextInt();
				scanner.next();
				if(numGiocatori<2||numGiocatori>4){
					System.out.println("numero di giocatori non disponibile\n");
				}else{
					System.out.println("Giocatori selezionati: "+numGiocatori+"\n");
					break;
				}
			}
			while(true);
				
			
			while(numGiocatori>0){
				System.out.println("Menu aggiunta giocatore "+ pos+1 + ":\n");
				/*nave=new Nave(componenti);
				plancia= new PlanciaNave(pos, nave);
				pos++;  
				System.out.prinln("Inserisci il nome del Giocatore "+pos+": ");
				nome=scanner.nextLine();
				Giocatore giocatore= new Giocatore(nome, plancia);
				System.out.println("Giocatore creato correttamente");
				listaGiocatori.add(giocatore);
					*/
				
				numGiocatori--;
			}
		    
		    
		    
		    
		    mazzoCarte = new Mazzo();
			mazzoCarte.caricaCarte();
			mazzoCarte.mischiaMazzo();
			
			System.out.println("Mazzo creato!");
			
			System.out.println("Creazione della nave\n");
			//L'unico valore che deve essere generato è la lista dei componenti
			//Possiamo generarla in maniera casuale e mostrare all'utente i componenti che avrà nella navicella poi passiamo la lista nel costruttore
			
			
	        while (!fineTurno) {
	        	
	        	ComponenteNave componenteRandom = pesca.pescaComponenteCasuale();

	            if (componenteRandom == null) {
	                System.out.println("Niente più componenti!");
	                break;
	            }

	            System.out.println("Hai pescato: " + componenteRandom.getTipo());

	            System.out.print("Inserire le coordinate x ed y (0 -1 e -1 per scartare: ");
	            int x = scanner.nextInt();
	            int y = scanner.nextInt();

	            if (x == -1 && y == -1) {
	                pesca.returnComponente(componenteRandom);
	                System.out.println("fine turno.");
	                fineTurno = true;
	                continue;
	            }

	            if (plancia.piazzaComponente(x, y, componenteRandom)) {
	                System.out.println("Componente piazzata!");
	                fineTurno = true;
	            } else {
	                System.out.println("Piazzamento errato. Riprova");
	                pesca.returnComponente(componenteRandom);
	            }

	            plancia.toString();
	        }
			
	        
	        System.out.println("Componenti presenti: ");
	        
	        /*for(ComponenteNave h: plancia.getComponente()) {
	        	System.out.println(h.toString());
	        }*/ //Per farlo funzionare i compenenti nave all'interno della plancia vanno spostati nella nave
	        
	        
			
		}catch(Exception h){ //Dobbiamo mettere l'Exception specifica (magari con più catch)
			h.printStackTrace();
		}
	
	
	        
	}
}

	   

