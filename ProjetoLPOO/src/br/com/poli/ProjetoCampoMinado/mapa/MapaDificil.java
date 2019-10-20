package br.com.poli.ProjetoCampoMinado.mapa;

import br.com.poli.ProjetoCampoMinado.Dificuldade;

public class MapaDificil extends Mapa{
     public final static Dificuldade TAMANHO = Dificuldade.DIFICIL;//atribui��o do tamanho do grid � dificuldade em quest�o
     public final static int BOMBAS = 99;//atribui��o do n�mero de bombas que a matriz dessa dificuldade deve ter
	public MapaDificil() {
		super(BOMBAS, TAMANHO.getValor());//construtor
	}
	
}
