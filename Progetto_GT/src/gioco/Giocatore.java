package gioco;

import java.util.ArrayList;

public class Giocatore {

	private String nome;
	private PlanciaNave nave;
	private int punteggio;
	protected static ArrayList<String> listaNomi = new ArrayList<>();
	
	public Giocatore(String nome, PlanciaNave nave) throws Exception {
		setNome(nome);
		setNave(nave);
		setPunteggio(0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)throws Exception{
		if(nome.isBlank() || listaNomi.contains(nome)) {
			throw new Exception("Il nome inserito è già stato utilizzato!");
		}
		
		this.nome = nome;
		listaNomi.add(nome);
	}

	public PlanciaNave getNave() {
		return nave;
	}

	public void setNave(PlanciaNave nave) {
		this.nave = nave;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public String toString() {
		return "Giocatore: " + getNome() + "\nPunteggio: " + getPunteggio() + "\n Informazioni nave: " + getNave(); 
	}
	
}
