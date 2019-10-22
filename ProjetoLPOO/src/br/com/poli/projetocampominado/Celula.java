package br.com.poli.projetocampominado;

public class Celula {//cria��o das c�lulas, que servir�o como tipo dos elementos do array bidimensional "campo"
	private boolean bandeira;//se a c�lula � uma bandeira ou n�o
	private boolean bomba;//se a c�lula � uma bomba ou n�o
	private boolean visivel;//se a c�lula est� vis�vel
	private int qtdBombasVizinhas;//o n�mero de c�lulas com o booleano bomba=true ao redor
	//construtor que ser� inicializado no m�todo inicializarC�lulas
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
