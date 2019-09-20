package br.com.poli.ProjetoCampoMinado;

public enum Dificuldade {
	
	FACIL(9),DIFICIL(16);

	private int valor;
	private Dificuldade(int valor) {
		
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
