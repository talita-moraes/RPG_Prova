
public abstract class ReinoFogo extends Criacao implements IRetiraPV, IIncluirPV{
	
	//construtor
	ReinoFogo(){
			
	}
	
	//Metodos 
	@Override
	public void retiraPontosDeVida(int p) {
		setPontosDeVida(getPontosDeVida() - p);
		
	}

	@Override
	public void incluirPontosDeVida(int p) {
		setPontosDeVida(getPontosDeVida() + p);
		
	}
	
}
