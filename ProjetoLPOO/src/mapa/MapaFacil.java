package mapa;

import jogo.Dificuldade;

public class MapaFacil extends Mapa {
    public final static Dificuldade TAMANHO = Dificuldade.FACIL;//atribui��o do tamanho do grid � dificuldade em quest�o
    public final static int BOMBAS = 10;//atribui��o do n�mero de bombas que a matriz dessa dificuldade deve ter
	public MapaFacil() {
		super(BOMBAS, TAMANHO.getValor());//construtor
	}
    

    
}
