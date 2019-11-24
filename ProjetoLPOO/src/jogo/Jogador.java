package jogo;

public class Jogador {
	// classe contendo apenas o nome do jogador como atributo e seu método getter
	private String nome;
	private int tempo;	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome+": "+tempo;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	

}
