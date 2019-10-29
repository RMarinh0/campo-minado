package br.com.poli.projetocampominado;

import java.util.ArrayList;
import java.util.List;

public class Celula {// criação das células, que servirão como tipo dos elementos do array
						// bidimensional "campo"
	private boolean bandeira;// se a célula é uma bandeira ou não
	private boolean bomba;// se a célula é uma bomba ou não
	private boolean visivel;// se a célula está visível
	private int qtdBombasVizinhas;// o número de células com o booleano bomba=true ao redor
	private int linha;
	private int coluna;
	private ArrayList<Celula> vizinhos = new ArrayList<Celula>();

	// construtor que será inicializado no método inicializarCélulas
	public Celula(/*boolean bandeira, boolean bomba, boolean visivel, int qtdBombasVizinhas, */int linha, int coluna) {
		/*this.bandeira = bandeira;
		this.bomba = bomba;
		this.visivel = visivel;
		this.qtdBombasVizinhas = qtdBombasVizinhas;*/
		this.linha = linha;
		this.coluna = coluna;
	}

	/*public void buscarVizinhos(Celula[][] campo) {
		for (int k = i - 1; k <= i + 1; k++) {
			if (k >= 0 && k < campo.length) {
				for (int l = j - 1; l <= j + 1; l++) {
					if (l >= 0 && l < campo.length) {
						vizinhos.add(campo[k][l]);// vai ser inicilizado na revelarEspacos e ir adicionando os vizinhos
											      // na lista
					}
				}
			}
		}
	}*/

	public boolean isEmBranco() {
		if (qtdBombasVizinhas == 0)
			return true;
		else
			return false;
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

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}
