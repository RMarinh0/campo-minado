package mapa;

import jogo.Dificuldade;

public class MapaMedio extends Mapa {
     public final static Dificuldade TAMANHO = Dificuldade.MEDIO;//atribui��o do tamanho do grid � dificuldade em quest�o
     public final static int BOMBAS = 01;//atribui��o do n�mero de bombas que a matriz dessa dificuldade deve ter
	public MapaMedio() {
		super(BOMBAS,TAMANHO.getValor());//construtor
	}
	
     
     
}
