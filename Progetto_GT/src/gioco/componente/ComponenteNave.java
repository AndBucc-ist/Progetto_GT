package gioco.componente;

public abstract class ComponenteNave {
	
	private int id;
	private int poszioneX;
	private int posizioneY;
	
	public ComponenteNave() {
	}
	
	public ComponenteNave(int id) {
		this.id=id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "";
	}

}
