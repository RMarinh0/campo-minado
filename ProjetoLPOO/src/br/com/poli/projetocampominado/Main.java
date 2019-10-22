package br.com.poli.projetocampominado;
// Arthur Falcão - Rafael Marinho
public class Main {
	public static void main(String[] args) {
	    //exemplos com cada dificuldade e suas três variações: exemplo invisível, exemplo de jogada e modo de teste:
		CampoMinado teste = new CampoMinado("Fulano",Dificuldade.FACIL);
		teste.getMapa().imprimeTela(false);
		System.out.println();
        teste.getMapa().escolherPosicao(0,0);//primeira linha e primeira coluna
        System.out.println();
        teste.getMapa().imprimeTela(true);
        
        System.out.println("----------------------------------------------------------------");
        
        CampoMinado testemedio = new CampoMinado("Beltrano",Dificuldade.MEDIO);
		testemedio.getMapa().imprimeTela(false);
		System.out.println();
        testemedio.getMapa().escolherPosicao(0,0);
        System.out.println();
        testemedio.getMapa().imprimeTela(true);
        
        System.out.println("----------------------------------------------------------------");
        
        CampoMinado testedificil = new CampoMinado("Sicrano",Dificuldade.DIFICIL);
		testedificil.getMapa().imprimeTela(false);
		System.out.println();
        testedificil.getMapa().escolherPosicao(0,0);
        System.out.println();
        testedificil.getMapa().imprimeTela(true);


	}
}
