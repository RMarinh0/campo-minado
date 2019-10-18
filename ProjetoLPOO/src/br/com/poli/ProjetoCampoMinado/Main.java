package br.com.poli.ProjetoCampoMinado;
// Arthur Falcão - Rafael Marinho
public class Main {
	public static void main(String[] args) {
	 
		CampoMinado teste = new CampoMinado("Fulano",Dificuldade.FACIL);
		teste.getMapa().imprimeTela(false);
		System.out.println();
        teste.getMapa().escolherPosicao(0,0);
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
