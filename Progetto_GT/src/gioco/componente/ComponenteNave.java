package gioco.componente;

public abstract class ComponenteNave {
	
	public int id;
	private int poszioneX;
	private int posizioneY;
	
	public ComponenteNave() {
	}
	
	public ComponenteNave(int id) {
		this.id=id;
	}


	public String toString() {
		return "";
	}

}
