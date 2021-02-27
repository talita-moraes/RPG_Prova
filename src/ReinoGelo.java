
public class ReinoGelo extends Criacao implements IRetiraPV, IIncluirPV{
	
	//construtor
	ReinoGelo(){
		
	}
	
	//Metodos 
	@Override
	public void retiraPontosDeVida(int p) {
		setPontosDeVida(getPontosDeVida() - p);
		
	}

	@Override
	public void incluirPontosDeVida(int p) {
		// TODO Auto-generated method stub
		
	}

}
