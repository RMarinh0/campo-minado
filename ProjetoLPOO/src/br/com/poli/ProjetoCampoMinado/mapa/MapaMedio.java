package br.com.poli.ProjetoCampoMinado.mapa;

import br.com.poli.ProjetoCampoMinado.Dificuldade;

public class MapaMedio extends Mapa {
     public final static Dificuldade TAMANHO = Dificuldade.MEDIO;//atribuição do tamanho do grid à dificuldade em questão
     public final static int BOMBAS = 40;//atribuição do número de bombas que a matriz dessa dificuldade deve ter
	public MapaMedio() {
		super(BOMBAS,TAMANHO.getValor());//construtor
	}
	
     
     
}
