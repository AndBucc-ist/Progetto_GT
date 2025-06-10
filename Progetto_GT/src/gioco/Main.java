package gioco;

public class Main {

	
	public static void main(String[] args) {
			
			try {
				Gioco gioco= new Gioco();
				gioco.iniziaPartita();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
	

