package gioco;
/**
 * Classe principale del programma.
 * 
 * Serve per far partire il gioco.
 */
public class Main {

/**
* Metodo principale. Viene eseguito per primo quando si avvia il programma.
* 
* Crea un nuovo gioco e lo avvia.
* Se succede un errore, lo stampa.
*
* @param args argomenti da riga di comando (non usati)
*/
	public static void main(String[] args) {
			
			try {
				Gioco gioco= new Gioco();
				gioco.iniziaPartita();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
	

