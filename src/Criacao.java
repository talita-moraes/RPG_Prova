
public abstract class Criacao {
	
	//atributo
	private String Nome;
	private int pontosDeVida;
	
	//construtor
	Criacao(){
		
	}
	
	//metodos 
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}
	
	public boolean personagemMorreu(){
		
		if (pontosDeVida <=0){
			return true;
		} else{
			return false;
		}
		
	}
	
}
