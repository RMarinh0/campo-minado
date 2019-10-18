package br.com.poli.ProjetoCampoMinado;

public class MapaFacil extends Mapa {
    private final static Dificuldade TAMANHO = Dificuldade.FACIL;
    private final static int BOMBAS = 10;
	public MapaFacil() {
		super(BOMBAS, TAMANHO.getValor());
	}
    

    
}
