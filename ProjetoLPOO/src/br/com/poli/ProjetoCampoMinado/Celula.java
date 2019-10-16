package br.com.poli.ProjetoCampoMinado;

public class Celula {
	private boolean bandeira;
	private boolean bomba;
	private boolean visivel;
	private int qtdBombasVizinhas;
	
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
