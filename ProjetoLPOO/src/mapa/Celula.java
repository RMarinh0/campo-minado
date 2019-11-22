package mapa;

import java.util.ArrayList;
import java.util.List;

import gui.TelaJogo;

public class Celula {// cria��o das c�lulas, que servir�o como tipo dos elementos do array
						// bidimensional "campo"
	private boolean bandeira;// se a c�lula � uma bandeira ou n�o
	private boolean bomba;// se a c�lula � uma bomba ou n�o
	private boolean visivel;// se a c�lula est� vis�vel
	private int qtdBombasVizinhas;// o n�mero de c�lulas com o booleano bomba=true ao redor
	private int linha;
	private int coluna;
	private ArrayList<Celula> vizinhos = new ArrayList<Celula>();

	// construtor que ser� inicializado no m�todo inicializarC�lulas
	public Celula(int linha, int coluna) {
       //n�o ser� mais necess�rio inicializar bombas, bandeiras, visibilidade ou quantidade de bombas no construtor, j� que existem m�todos que
	   //automaticamente alteram o valor dessas vari�veis ao inicializar as c�lulas
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
								campo[i][j].vizinhos.add(campo[k][l]);//cada matriz ter� uma lista contendo cada uma de suas c�lulas vizinhas
                                                                      //al�m de ajudar no clean code, buscarVizinhos agilizar� o m�todo revelarEspa�os()
							}
						}
					}
				}
			}
		}
	}

	public boolean isEmBranco() {//m�todo que verifica se a c�lula em quest�o � um espa�o em branco
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
