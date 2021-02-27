
public class Cavaleiro extends ReinoFogo{
	//atributos
	private int durabilidadeMagia;
	
	//construtor
	Cavaleiro(){
				
	}
		
	//Metodos 
	public int getDurabilidadeMagia() {
		return 10;
	}

	public void setDurabilidadeMagia(int durabilidadeMagia) {
		this.durabilidadeMagia = durabilidadeMagia;
	}
	
	public int usarEspada() {
		// TODO Auto-generated method stub
		if (getDurabilidadeMagia()>0){
			setDurabilidadeMagia( getDurabilidadeMagia()- 1 );
			return 2;
		} else{
			return 1;
		}
		
	}

}
