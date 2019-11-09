package mapa;

import jogo.Dificuldade;

public class MapaDificil extends Mapa{
     public final static Dificuldade TAMANHO = Dificuldade.DIFICIL;//atribuição do tamanho do grid à dificuldade em questão
     public final static int BOMBAS = 99;//atribuição do número de bombas que a matriz dessa dificuldade deve ter
	public MapaDificil() {
		super(BOMBAS, TAMANHO.getValor());//construtor
	}
	
}
