package br.com.poli.ProjetoCampoMinado;

public class Main {
	public static void main(String[] args) {
		Mapa mapa = new Mapa(Dificuldade.FACIL);
		mapa.inicializaCampo();
		mapa.imprimeTela();
	}
}
