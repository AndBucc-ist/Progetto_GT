package gioco;
import java.util.ArrayList;
import java.util.Scanner;
import gioco.carte.Mazzo;
import gioco.componente.ComponenteNave;

public class Main {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		ArrayList <Giocatore> listaGiocatori=new ArrayList<>();
		String nome;
		System.out.println("GALAXY TRUCKER");
		
	                System.out.println("Partita livello 1 (default)");
		
			int numGiocatori=0;
			do{
				System.out.println("In quanti volete giocare? (max 4)");
				numGiocatori=scanner.nextInt();
				scanner.next();
				if(numGiocatori<2||numGiocatori>4){
					System.out.println("numero di giocatori non disponibile");
				}else{
					System.out.prinln("Giocatori selezionati: "+numGiocatori);
					break;
				}
			}
			while(True);
		int pos=0;
		while(numGiocatori>0){
			System.out.println("Menu aggiunta giocatore "+ pos+1 +":\n";
			/*Nave nave=new Nave(componenti);
   			PlanciaNave plancia= new PlanciaNave(pos, nave);
				pos++;  
    				System.out.prinln("Inserisci il nome del Giocatore "+pos+": ");
				nome=scanner.nextLine();
    				Giocatore giocatore= new Giocatore(nome, plancia);
				System.out.println("Giocatore creato correttamente");
    				listaGiocatori.add(giocatore);
       			*/
			
			numGiocatori--;
		}
	}
	
}
