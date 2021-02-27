import java.util.Scanner;

public class Executar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cavaleiro cavaleiro = new Cavaleiro();
		Fada fada = new Fada();
		Mago mago = new Mago();
		Monstro monstro = new Monstro();
		
		Scanner teclado = new Scanner(System.in);
		Batalha bt = new Batalha();
		
		//inicio jogo		
		String opcao;
		System.out.println(menu("0"));
		opcao = teclado.next();
			while( !opcao.equals("1") && !opcao.equals("2")){
				System.out.println("Digite Novamente: ");
				opcao = teclado.next();
			}
		
		System.out.println(menu(opcao));	//escolha 1ª Personagem
		
		int escolhaP  = teclado.nextInt();
			while( escolhaP!=1 && escolhaP!= 2){
				System.out.println("Digite Novamente: ");
				escolhaP = teclado.nextInt();
			}
			
			String p1 = null; //descobri personagem
			if (opcao.equals("1")){
				switch (escolhaP) {
				
				case 1:
					bt.setPersonagemGelo(fada);
					 p1="f";
					break;
				case 2:
					bt.setPersonagemGelo(monstro);
					 p1="mo";
					break;
				}
				
			} else if (opcao.equals("2")){
				switch (escolhaP) {
				case 1:
					bt.setPersonagemFogo(cavaleiro);
					 p1="c";
					break;
				case 2:
					bt.setPersonagemFogo(mago);
					 p1="ma";
					break;
				}

			}
			
		
			
		System.out.println(linha() + "\nEscolha 2 º jogador: ");	//escolha 2ª Personagem
		
		String p2 = null;//descobri 2 personagem
		if (opcao.equals("1")){
			System.out.println(menu("2"));
			
			escolhaP  = teclado.nextInt();
			while( escolhaP!=1 && escolhaP!= 2){
				System.out.println("Digite Novamente: ");
				escolhaP = teclado.nextInt();
			}
			
			switch (escolhaP) {
			case 1:
				bt.setPersonagemFogo(cavaleiro);
				p2="c";
				break;
			case 2:
				bt.setPersonagemFogo(mago);
				p2="ma";
				break;
			}
				
		} else if(opcao.equals("2")){
			System.out.println(menu("1"));
			
			escolhaP  = teclado.nextInt();
			while( escolhaP!=1 && escolhaP!= 2){
				System.out.println("Digite Novamente: ");
				escolhaP = teclado.nextInt();
			}
			
			switch (escolhaP) {
			case 1:
				bt.setPersonagemGelo(fada);
				p2="f";
				break;
			case 2:
				bt.setPersonagemGelo(monstro);
				p2="mo";
				break;
			}
			
		}
		
		
		System.out.println(linha()+ "\n Jogadores \n\n Reino Fogo: "+ defineNome(bt.getPersonagemFogo()) + "\n\n Reino Gelo: "+ defineNome(bt.getPersonagemGelo()));
		
		
		//Que os jogos comecem
		System.out.println(linha()+ "\n BATALHA \n                    GO! \n ");
		
		int lutar=2;
		//terminar batalha e metodos de campião
		
		while(lutar!=0){
			int acaoF = 0;
			int acaoG = 0;
			
			if(lutar % 2 == 0 ){
				if (p1.equals("c") || p2.equals("c")){
					System.out.println("\nCavaleiro: \nDigite 1: atarcar " );
					
					acaoF  = teclado.nextInt();
					while( acaoF!=1){
						System.out.println("Digite Novamente: ");
						acaoF = teclado.nextInt();
					}	
					
				} else if(p1.equals("ma")|| p2.equals("ma")){
					System.out.println("\nMago: \nDigite 1: atarcar |   Digite 2: Regenerar vida" );
					acaoF  = teclado.nextInt();
					while( acaoF!=1 && acaoF!= 2){
						System.out.println("Digite Novamente: ");
						acaoF = teclado.nextInt();
					}
				}
				
			} else{
				if (p1.equals("mo")|| p2.equals("mo")){
					System.out.println("\nMonstro: \nDigite 1: atarcar " );
					
					acaoG  = teclado.nextInt();
					while( acaoG!=1){
						System.out.println("Digite Novamente: ");
						acaoG = teclado.nextInt();
					}
				}else if(p1.equals("f")|| p2.equals("f")) {
					System.out.println("\nFada: \nDigite 1: atarcar |   Digite 2: Regenerar vida" );
					
					acaoG  = teclado.nextInt();
					while( acaoG!=1 && acaoG!= 2){
						System.out.println("Digite Novamente: ");
						acaoG = teclado.nextInt();
						
					}
				}
			}
			
			//metodo para lutar
			System.out.println(lutar(bt.getPersonagemFogo(), bt.getPersonagemGelo(),acaoF, acaoG));
			
			//finalizar
			
			if (bt.getPersonagemGelo().getPontosDeVida()<=0 || bt.getPersonagemFogo().getPontosDeVida()<=0  ){
				System.out.println(linha() + "\nO vencedor é: " + bt.vencedor()+ "\nO perdedor é: " + bt.perdedor());
				lutar = 0;
				
			} else{
				lutar = lutar +1;			
			}
			
			System.out.println("\n Estado: " + defineAcaoG(bt.getPersonagemGelo()));
			System.out.println("\n Estado: " + defineAcaoF(bt.getPersonagemFogo()));
			
		}
	}
	
	public static String lutar(ReinoFogo f, ReinoGelo g, int acaoF, int acaoG){
		
		String nome = "";
		
		if(acaoG==2){
			nome = "\nAcao: regenerando";
			
			if(g instanceof Fada){
				g.incluirPontosDeVida(acaoG);
			} 
		} else if (acaoF==2){
			if(f instanceof Mago){
				f.incluirPontosDeVida(acaoF);
			}
		}
		
		if(acaoG==1){
			if(g instanceof Fada){
				acaoG = ((Fada) g).usarMagia();
				nome = "\nAcão: magia";
				
			} else if(g instanceof Monstro){
				acaoG = ((Monstro) g).darSoco();
				nome = "\nAcão: soco";
				
			}
			  
		}else if (acaoF==1){
			acaoG= 0;
			acaoF= 0;
			if(f instanceof Cavaleiro){
				acaoF = ((Cavaleiro) f).usarEspada();
				nome = "\nAcão: espada";
				
			} else if(f instanceof Mago){
				acaoF = ((Mago) f).usarPoMagico();
				nome = "\nAcão: pó magico";
						
			} 
		} 
		
			if(g instanceof Fada){
				g.retiraPontosDeVida(acaoF);
				
			} else if(g instanceof Monstro){
				g.retiraPontosDeVida(acaoF);
				
			}
			
			if(f instanceof Cavaleiro){
				f.retiraPontosDeVida(acaoG);
				
			} else if(f instanceof Mago){
				f.retiraPontosDeVida(acaoG);
			} 
			
			return nome;
		
	}
	

	public static String defineAcaoF(ReinoFogo f){
			  
			if(f instanceof Cavaleiro){
				return ("\n Nome: " + f.getNome() + "\n Pontos de vida:" + f.getPontosDeVida());
			
			} else if(f instanceof Mago){
				return ("\n Nome: " + f.getNome() + "\n Pontos de vida:" + f.getPontosDeVida());
			
			} 
			
			return null;	
	}
	
	public static String defineAcaoG(ReinoGelo g){
		
		if(g instanceof Fada){
			return ("\n Nome: " + g.getNome() + "\n Pontos de vida:" + g.getPontosDeVida());
		} else if(g instanceof Monstro){
			return ("\n Nome: " + g.getNome() + "\n Pontos de vida:" + g.getPontosDeVida());
		}
		
		return null;	
	}

	public static String defineNome(Criacao c){
		
		if(c instanceof Mago){
			c.setNome("Harry Potter");
			c.setPontosDeVida(15);
			return ("\n Nome: " + c.getNome() + "\n Pontos De Vida: " + c.getPontosDeVida());
			
		} else if(c instanceof Fada){
			c.setNome("Sininho");
			c.setPontosDeVida(10);
			return ("\n Nome: " + c.getNome() + "\n Pontos De Vida: " + c.getPontosDeVida());
			
		} else if(c instanceof Monstro){
			c.setNome("Hulk");
			c.setPontosDeVida(35);
			return ("\n Nome: " + c.getNome() + "\n Pontos De Vida: " + c.getPontosDeVida());
			
		} else if(c instanceof Cavaleiro){
			c.setNome("Zorro");
			c.setPontosDeVida(20);
			return ("\n Nome: " + c.getNome() + "\n Pontos De Vida: " + c.getPontosDeVida());
			
		} 
		 
		return "";
		 
		}
	
	public static String linha(){
		
		String carctere = "";
		
		for(int i = 0; i<50; i++){
			carctere = carctere + "_";
		}
		
		return carctere;
	}
	

	public static String menu(String nome){
		
		String nomeT, titulo;
		String tipo1 = "\n 1- Reino Gelo";
		String tipo2 = "\n 2- Reino Fogo";
		
			if(nome.equals("0")){
				nomeT = "\n Escolha 1º Jogador";
				titulo = tipo1 + tipo2;
			} else if (nome.equals("2")){
				nomeT = "\n Personagem: Reino Fogo";
				titulo = "\n 1- Cavaleiro \n 2- Mago";
			} else if (nome.equals("1")){
				nomeT = "\n Personagem: Reino Gelo";
				titulo = "\n 1- Fada \n 2- Monstro";
			}  else {
				nomeT = "\n Resultado";
				titulo = "";
			}

		return ( linha()+ nomeT+ "\n"+ linha()+ titulo + "\n" + linha());
	}

}
