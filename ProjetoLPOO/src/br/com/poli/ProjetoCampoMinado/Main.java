package br.com.poli.ProjetoCampoMinado;
// Arthur Falcão - Rafael Marinho
public class Main {
	public static void main(String[] args) {
	 
		CampoMinado teste = new CampoMinado("Fulano",Dificuldade.FACIL);
		
        teste.getMapa().imprimeTela(true);
        


	}
}
