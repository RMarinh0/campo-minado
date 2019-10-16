package br.com.poli.ProjetoCampoMinado;

import java.util.Random;

public abstract class Mapa {
	private Celula[][] campo;
	// array do tipo celula
	private Dificuldade dificuldade;

	public Mapa(int bombas, int tamanho) {
		// a seguir, a inicializa��o do array campo, utilizando os valores da respectiva
		// dificuldade como "i" e "j"
		this.campo = new Celula[tamanho][tamanho];
		// implementa��o dos m�todos no construtor da classe, com prop�sito de
		// agiliza��o
		inicializarCelulas();
		distribuirBombas(bombas);
		this.contarBombas();
	}

	public void imprimeTela(boolean teste) {
		// impress�o da matrin nxn, com n sendo o valor da dificuldade escolhida
		if (teste == false) {
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					if (campo[i][j].isVisivel() == true) {
						System.out.print(campo[i][j].getQtdBombasVizinhas());
					}
					System.out.println();
				}
			}
		} else {
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					System.out.print(campo[i][j].getQtdBombasVizinhas());
				}
				System.out.println();
			}
		}
	}

	private void distribuirBombas(int bombas) {
		Random random = new Random();
		for (int i = 0; i < bombas; i++) {// tendo em mente que o array tipo int � inicializado com todos os elementos
			// como 0...
			int x = random.nextInt(campo.length);// uma linha aleat�ria do array
			int y = random.nextInt(campo.length);// uma coluna aleat�ria do array
			// ou seja, um elemento [x][y] aleat�rio
			if (campo[x][y].isBomba() == false)
				campo[x][y].setBomba(true);// para cada percorrida do array, um 0 aleat�rio ser� substitu�do por uma
			else // bomba(-1)
				i--;// garantia de que um mesmo elemento n�o ter� uma bomba posta em cima da outra
		}
	}

	private void inicializarCelulas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(false, false, false, 0);
			}
		}
		// quais os booleans que a c�lula deve ter quando for inicializada?
	}

	public void escolherPosicao(int linha, int coluna) {

	}

	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba() == false) {
					for (int k = i - 1; k <= i + 1; k++) {
						if (k > 0 && k < campo.length) {
							for (int l = j - 1; l <= j + 1; l++) {
								if (l > 0 && l < campo.length) {
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
