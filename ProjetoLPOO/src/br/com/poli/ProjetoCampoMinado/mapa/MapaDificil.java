package br.com.poli.ProjetoCampoMinado;

public class MapaDificil extends Mapa{
     public final static Dificuldade TAMANHO = Dificuldade.DIFICIL ;
     public final static int BOMBAS = 99;
	public MapaDificil() {
		super(BOMBAS, TAMANHO.getValor());
	}
	
}
