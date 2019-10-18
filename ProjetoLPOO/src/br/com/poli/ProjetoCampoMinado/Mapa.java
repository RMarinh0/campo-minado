package br.com.poli.ProjetoCampoMinado;

import java.util.Random;

public abstract class Mapa {
	private Celula[][] campo;
	// array do tipo celula
	private Dificuldade dificuldade;

	public Mapa(int bombas, int tamanho) {
		// a seguir, a inicialização do array campo, utilizando os valores da respectiva
		// dificuldade como "i" e "j"
		this.campo = new Celula[tamanho][tamanho];
		// implementação dos métodos no construtor da classe, com propósito de
		// agilização
		inicializarCelulas();
		distribuirBombas(bombas);
		contarBombas();
		
	}

	public void imprimeTela(boolean teste) {
		// impressão da matrin nxn, com n sendo o valor da dificuldade escolhida
		if (teste == true) {
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					if (campo[i][j].isBomba() == false) {
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
					} else {
						System.out.print(" B");
					}

				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					if(campo[i][j].isVisivel()==false)
					System.out.print(" -");
					else if(campo[i][j].isBomba()==true) 
						System.out.print(" B");
					else
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
				}
				System.out.println();
			}
		}
	}

	private void distribuirBombas(int bombas) {
		Random random = new Random();
		for (int i = 0; i < bombas; i++) {// tendo em mente que o array tipo int é inicializado com todos os elementos
			// como 0...
			int x = random.nextInt(campo.length);// uma linha aleatória do array
			int y = random.nextInt(campo.length);// uma coluna aleatória do array
			// ou seja, um elemento [x][y] aleatório
			if (campo[x][y].isBomba() == false)
				campo[x][y].setBomba(true);// para cada percorrida do array, um 0 aleatório será substituído por uma
			else // bomba(-1)
				i--;// garantia de que um mesmo elemento não terá uma bomba posta em cima da outra
		}
	}

	private void inicializarCelulas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(false, false, false, 0);
			}
		}
		// quais os booleans que a célula deve ter quando for inicializada?
	}

	public void escolherPosicao(int linha, int coluna) {

		if (campo[linha][coluna].isBomba() == true) {
			campo[linha][coluna].setVisivel(true);
			System.out.println("FIM DE JOGO! VOCÊ PERDEU");
		} else if (campo[linha][coluna].getQtdBombasVizinhas() > 0) {
			campo[linha][coluna].setVisivel(true);
		} else if (campo[linha][coluna].getQtdBombasVizinhas() == 0) {
			checarVazios(linha, coluna);
		}

		imprimeTela(false);
	}

	public void checarVazios(int i, int j) {
		for (int k = i - 1; k <= i + 1; k++) {
			if (k >= 0 && k < campo.length) {
				for (int l = j - 1; l <= j + 1; l++) {
					if (l >= 0 && l < campo.length) {
						if (campo[k][l].getQtdBombasVizinhas() == 0 && campo[k][l].isVisivel() == false) {
							campo[k][l].setVisivel(true);
							checarVazios(k, l);
						}
						else if(campo[k][l].getQtdBombasVizinhas()>0) {
							campo[k][l].setVisivel(true);
						}
					}
				}
			}
		}
	}

	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba() == false) {
					for (int k = i - 1; k <= i + 1; k++) {
						if (k >= 0 && k < campo.length) {
							for (int l = j - 1; l <= j + 1; l++) {
								if (l >= 0 && l < campo.length) {
									if (campo[k][l].isBomba() == true) {
										campo[i][j].setQtdBombasVizinhas(campo[i][j].getQtdBombasVizinhas() + 1);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public Celula[][] getCampo() {
		return campo;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}
