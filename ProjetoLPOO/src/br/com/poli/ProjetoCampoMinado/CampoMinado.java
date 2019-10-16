package br.com.poli.ProjetoCampoMinado;

public class CampoMinado {
	private Jogador jogador;
	private Dificuldade dificuldade;
	private Mapa mapa;

	public CampoMinado(String nome, Dificuldade dificuldade) {
		// construtor usado na main para a criação de um campo minado
		this.jogador = new Jogador(nome);
		this.dificuldade = dificuldade;
		// o paramêtro dificuldade será aproveitado para a formação do mapa
		switch(dificuldade) {
		case FACIL:
			this.mapa = new MapaFacil();
			break;
		case MEDIO:
			this.mapa = new MapaMedio();
			break;
		case DIFICIL:
			this.mapa = new MapaDificil();
			break;
		}
		
	}

	public Jogador getJogador() {
		return this.jogador;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	

}
