package br.com.poli.ProjetoCampoMinado;

public class CampoMinado {
 private Jogador jogador;
private Dificuldade dificuldade;
private Mapa mapa;

public CampoMinado(String nome, Dificuldade dificuldade) {//construtor usado na main para a criação de um campo minado
	this.jogador = new Jogador(nome);
	this.dificuldade=dificuldade;
	//o paramêtro dificuldade será aproveitado para a formação do mapa
	this.mapa = new Mapa(dificuldade);
}

public Jogador getJogador() {
	return this.jogador;
}
public Mapa getMapa() {
	return this.mapa;
}


}
