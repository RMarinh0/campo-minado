package br.com.poli.ProjetoCampoMinado;

public enum Dificuldade {

	FACIL(9), MEDIO(16), DIFICIL(32);
	// pr�-definindo as tr�s dificuldades e seus valores por meio de um enum
	private int valor;

	// construtor
	private Dificuldade(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
