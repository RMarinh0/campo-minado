package mapa;

import java.util.ArrayList;
import java.util.List;

import gui.TelaJogo;

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
	public Celula(int linha, int coluna) {
       //não será mais necessário inicializar bombas, bandeiras, visibilidade ou quantidade de bombas no construtor, já que existem métodos que
	   //automaticamente alteram o valor dessas variáveis ao inicializar as células
		this.linha = linha;
		this.coluna = coluna;
	}

	public void buscarVizinhos(Celula[][] campo) {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				for (int k = i - 1; k <= i + 1; k++) {// verificando as 8 casas em volta do elemento vazio da matriz(vizinhos)
					if (k >= 0 && k < campo.length) { 
						for (int l = j - 1; l <= j + 1; l++) {
							if (l >= 0 && l < campo.length) {
								campo[i][j].vizinhos.add(campo[k][l]);//cada matriz terá uma lista contendo cada uma de suas células vizinhas
                                                                      //além de ajudar no clean code, buscarVizinhos agilizará o método revelarEspaços()
							}
						}
					}
				}
			}
		}
	}

	public boolean isEmBranco() {//método que verifica se a célula em questão é um espaço em branco
		if (qtdBombasVizinhas == 0)
			return true;
		else
			return false;
	}
	

	public boolean isBandeira() {
		return bandeira;
	}

	public ArrayList<Celula> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(ArrayList<Celula> vizinhos) {
		this.vizinhos = vizinhos;
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
