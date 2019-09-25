package br.com.poli.ProjetoCampoMinado;

public class CampoMinado {
 private Jogador jogador;
private Dificuldade dificuldade;
private Mapa mapa;

public CampoMinado(String nome, Dificuldade dificuldade) {
	this.jogador = new Jogador(nome);
	this.dificuldade = dificuldade;
	this.mapa = new Mapa(dificuldade);
}

public Jogador getJogador() {
	return this.jogador;
}
public Mapa getMapa() {
	return this.mapa;
}
}
