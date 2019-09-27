package br.com.poli.ProjetoCampoMinado;

public enum Dificuldade {

	FACIL(9), DIFICIL(16);
	// pré-definindo as duas dificuldades e seus valores por meio de um enum
	private int valor;

	// construtor
	private Dificuldade(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
