
public class Batalha {
	
	//atributos
	private ReinoFogo personagemFogo;
	private ReinoGelo personagemGelo;
	
	//metodos
	public ReinoFogo getPersonagemFogo() {
		return personagemFogo;
	}
	
	public void setPersonagemFogo(ReinoFogo personagemFogo) {
		this.personagemFogo = personagemFogo;
	}

	public ReinoGelo getPersonagemGelo() {
		return personagemGelo;
	}

	public void setPersonagemGelo(ReinoGelo personagemGelo) {
		this.personagemGelo = personagemGelo;
	}
	
	public String vencedor(){
		
		if (personagemFogo.getPontosDeVida() >0){
			return "Reino Fogo";
		} else if (personagemGelo.getPontosDeVida() >0){
			return "Reino Gelo";
		} else{
			return "";
		}
		
	}
	
	public String perdedor(){
		if (personagemFogo.getPontosDeVida() <=0){
			return "Reino Fogo";
		} else if (personagemGelo.getPontosDeVida() <=0){
			return "Reino Gelo";
		} else{
			return "";
		}
	}
	
	
	
	
	
}
