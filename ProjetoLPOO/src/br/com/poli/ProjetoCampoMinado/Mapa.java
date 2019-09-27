package br.com.poli.ProjetoCampoMinado;

import java.util.Random;

public class Mapa {
	private int[][] campo;
	private Dificuldade dificuldade;

	public Mapa(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
		// a seguir, a inicializa��o do array campo, utilizando os valores da respectiva
		// dificuldade como "i" e "j"
		this.campo = new int[dificuldade.getValor()][dificuldade.getValor()];
		// implementa��o dos m�todos no construtor da classe, com prop�sito de
		// agiliza��o
		this.inicializaCampo();
		this.imprimeTela();
	}

	public void inicializaCampo() {
		Random random = new Random();
		for (int i = 1; i <= 10; i++) {// tendo em mente que o array tipo int � inicializado com todos os elementos
										// como 0...
			int x = random.nextInt(campo.length);// uma linha aleat�ria do array
			int y = random.nextInt(campo.length);// uma coluna aleat�ria do array
			// ou seja, um elemento [x][y] aleat�rio
			if (campo[x][y] == 0)
				campo[x][y] = -1;// para cada percorrida do array, um 0 aleat�rio ser� substitu�do por uma
									// bomba(-1)
			else
				i--;// garantia de que um mesmo elemento n�o ter� uma bomba posta em cima da outra
		}
	}

	public void imprimeTela() {
		// impress�o da matrin nxn, com n sendo o valor da dificuldade escolhida
		for (int i = 0; i <= campo.length - 1; i++) {
			for (int j = 0; j <= campo.length - 1; j++) {
				if (campo[i][j] == -1) {
					System.out.print(campo[i][j] + " ");// os espa�os em branco servem apenas de est�tica
				} else {
					System.out.print(" " + campo[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public int[][] getCampo() {
		return campo;
	}

	public void setCampo(int[][] campo) {
		this.campo = campo;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}
