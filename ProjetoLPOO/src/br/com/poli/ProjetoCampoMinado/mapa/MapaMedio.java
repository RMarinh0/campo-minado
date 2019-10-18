package br.com.poli.ProjetoCampoMinado;

public class MapaMedio extends Mapa {
     public final static Dificuldade TAMANHO = Dificuldade.MEDIO;
     public final static int BOMBAS = 40;
	public MapaMedio() {
		super(BOMBAS,TAMANHO.getValor());
	}
	
     
     
}
