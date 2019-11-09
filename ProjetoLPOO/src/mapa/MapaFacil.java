package mapa;

import jogo.Dificuldade;

public class MapaFacil extends Mapa {
    public final static Dificuldade TAMANHO = Dificuldade.FACIL;//atribuição do tamanho do grid à dificuldade em questão
    public final static int BOMBAS = 10;//atribuição do número de bombas que a matriz dessa dificuldade deve ter
	public MapaFacil() {
		super(BOMBAS, TAMANHO.getValor());//construtor
	}
    

    
}
