
public class Mago extends ReinoFogo{
	//atributos
	private int quantidadePoMagico;
		
	//construtor
	Mago(){
					
	}
	
	//Metodos 
	public int getQuantidadePoMagico() {
		return 10;
	}

	public void setQuantidadePoMagico(int quantidadePoMagico) {
		this.quantidadePoMagico = quantidadePoMagico;
	}
			
	public int usarPoMagico(){
		if (getQuantidadePoMagico()>0){
			setQuantidadePoMagico( getQuantidadePoMagico()- 1 );
			return 2;
		} else{
			return 1;
		}
	}
	
	public void incluirPontosDeVida(int p) {
		setPontosDeVida(getPontosDeVida() + p);
		
	}
	
}
