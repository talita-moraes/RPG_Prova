
public class Fada extends ReinoGelo {
	
	//atributos
	private int durabilidadeMagia;
	
	//construtor
	Fada(){
			
	}
	
	//Metodos 
	public int getDurabilidadeMagia() {
		return 10;
	}

	public void setDurabilidadeMagia(int durabilidadeMagia) {
		this.durabilidadeMagia = durabilidadeMagia;
	}

	@Override
	public void incluirPontosDeVida(int p) {
		setPontosDeVida(getPontosDeVida() + p +3 );
		
	}

	public int usarMagia() {
		// TODO Auto-generated method stub
		if (getDurabilidadeMagia()>0){
			setDurabilidadeMagia( getDurabilidadeMagia()- 1 );
			return 3;
		} else{
			return 1;
		}
			
	}
}
	
