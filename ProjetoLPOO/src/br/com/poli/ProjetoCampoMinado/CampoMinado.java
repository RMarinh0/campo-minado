package br.com.poli.ProjetoCampoMinado;

public class CampoMinado {
 private Jogador jogador;
 public CampoMinado(Jogador jogador, Mapa mapa, Dificuldade dificuldade) {
	
	this.jogador = jogador;
	this.mapa = mapa;
	this.dificuldade = dificuldade;
}
private Mapa mapa;
 private Dificuldade dificuldade;
 
 
public Jogador getJogador() {
	return jogador;
}
public void setJogador(Jogador jogador) {
	this.jogador = jogador;
}
public Mapa getMapa() {
	return mapa;
}
public void setMapa(Mapa mapa) {
	this.mapa = mapa;
}
public Dificuldade getDificuldade() {
	return dificuldade;
}
public void setDificuldade(Dificuldade dificuldade) {
	this.dificuldade = dificuldade;
}
  //.

}
