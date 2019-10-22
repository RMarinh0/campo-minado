package br.com.poli.projetocampominado;

public class Celula {//criação das células, que servirão como tipo dos elementos do array bidimensional "campo"
	private boolean bandeira;//se a célula é uma bandeira ou não
	private boolean bomba;//se a célula é uma bomba ou não
	private boolean visivel;//se a célula está visível
	private int qtdBombasVizinhas;//o número de células com o booleano bomba=true ao redor
	//construtor que será inicializado no método inicializarCélulas
	public Celula(boolean bandeira, boolean bomba, boolean visivel, int qtdBombasVizinhas) {
		this.bandeira = bandeira;
		this.bomba = bomba;
		this.visivel = visivel;
		this.qtdBombasVizinhas = qtdBombasVizinhas;
	}
	public boolean isBandeira() {
		return bandeira;
	}
	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}
	public boolean isBomba() {
		return bomba;
	}
	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}
	
	public boolean isVisivel() {
		return visivel;
	}
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}
	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}
	public void setQtdBombasVizinhas(int qtdBombasVizinhas) {
		this.qtdBombasVizinhas = qtdBombasVizinhas;
	}

}
