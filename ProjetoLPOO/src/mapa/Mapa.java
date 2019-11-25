package mapa;

import java.util.Random;

import jogo.Dificuldade;

public abstract class Mapa {
	private Celula[][] campo;
	// array do tipo celula
	private Dificuldade dificuldade;
	private int bombas;
	private boolean fimDeJogo;
	private boolean ganhouJogo;
	private int celulasVisiveis;// cada vez que uma célula tornar-se visível, com exceção da bomba, essa
								// variável será incrementada para garantir
								// a condição de vitória
	public Mapa(int bombas, int tamanho) {
		// a seguir, a inicialização do array campo, utilizando os valores(tamanho) da
		// respectiva
		// dificuldade como "i" e "j"
		this.campo = new Celula[tamanho][tamanho];

		// implementação dos métodos no construtor da classe, com propósito de
		// agilização
		this.bombas = bombas;
		inicializarCelulas();
		distribuirBombas(bombas);
		contarBombas();
		percorrerVizinhos(campo);// assim que for criado o mapa, esse método dará a cada célula uma lista com
									// seus respectivos vizinhos

	}

	public void imprimeTela(boolean teste) {
		// impressão da matriz tamanhoxtamanho, com a expressão dos elementos dependendo
		// do valor booleano "teste"
		if (teste == true) {
			for (int i = 0; i < campo.length; i++) {// se o teste for verdadeiro, o valor das células não será oculto,
				for (int j = 0; j < campo.length; j++) {// permitindo a checagem do bom funcionamento da matriz
					if (campo[i][j].isBomba() == false) {
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());// se não for bomba, imprime vazio ou
																					// o n° de bombas ao redor
					} else {
						System.out.print(" @");
					}

				}
				System.out.println();
			}
		} else {// se o teste for falso, a matriz será impressa como se um jogo de verdade
				// estiver acontecendo
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					if (campo[i][j].isVisivel() == false)// se o elemento não for visível, uma interrogação será
															// impressa em seu lugar
						System.out.print(" -");
					else if (campo[i][j].isBomba() == true)
						System.out.print(" @");
					else
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
				} // repetição dos comandos da condição análoga, para que de qualquer forma as
					// impressões sejam satisfeitas
				System.out.println();
			}
		}
	}

	private void distribuirBombas(int bombas) {
		Random random = new Random();
		for (int i = 0; i < bombas; i++) {// a repetição do laço e colocação das bombas dependerá da dificuldade
			int x = random.nextInt(campo.length);// uma linha aleatória do array
			int y = random.nextInt(campo.length);// uma coluna aleatória do array
			// ou seja, um elemento [x][y] aleatório
			if (getCelula(x, y).isBomba() == false)
				getCelula(x, y).setBomba(true);// para cada percorrida do array, uma célula terá seu valor de bomba
												// convertido para "verdadeiro"
			else
				i--;// garantia de que um mesmo elemento não terá uma bomba posta em cima da outra
		}
	}

	private void inicializarCelulas() {// método que preenche o campo com Células
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(i, j);
			}
		}
	}


	public void escolherPosicao(int linha, int coluna) {// método que permite ao jogador escolher o elemento da matriz
		/*												// em que deseja jogar
		do {// garantir primeira posição branca
			if (!getCelula(linha, coluna).isEmBranco()) {
				Menu menu = new Menu();
				menu.setVisible(true);
				TelaJogo tela = new TelaJogo(this.getDificuldade());
				tela.setVisible(true);
				escolherPosicao(linha, coluna);
			}
		} while (contador < 1);*/
		if (getCelula(linha, coluna).isBomba() == true) {
			getCelula(linha, coluna).setVisivel(true);// se a posição escolhida for uma bomba, o jogo é "encerrado"
			System.out.println("Fim de Jogo! Você perdeu!");
			fimDeJogo = true;
		} else if (campo[linha][coluna].isEmBranco() == false) {
			getCelula(linha, coluna).setVisivel(true);// se a posição tiver bombas ao redor, ela é revelada contendo o
														// número de bombas ao redor

			celulasVisiveis++;
		} else if (getCelula(linha, coluna).isEmBranco() == true) {
			revelarEspacos(getCelula(linha, coluna));// se a posição for vazia, o método revelarEspacos é acionado,
														// usando recursividade para revelar todos os vazios em volta,
		} // e parar quando achar uma não vazia que não seja uma bomba

		imprimeTela(false);// ao final do método, a tela será impressa novamente com os valores
							// atualizados, deixando os inalterados invisíveis
		verificarGanhouJogo();
	}

	public void revelarEspacos(Celula celulaEscolhida) {
		for (Celula celula : celulaEscolhida.getVizinhos()) {// for que percorre os vizinhos que constam na lista de
																// vizinhos da célula escolhida,
			if (campo[celula.getLinha()][celula.getColuna()].isEmBranco() == true// sendo "celula" uma representação
																					// "descartável" desses vizinhos
					&& campo[celula.getLinha()][celula.getColuna()].isVisivel() == false) {
				campo[celula.getLinha()][celula.getColuna()].setVisivel(true);// se o vizinho for branco, tornará-se
																				// visível...
				celulasVisiveis++;
				revelarEspacos(campo[celula.getLinha()][celula.getColuna()]);// ...e o método será acionado
																				// recursivamente para esse vizinho,
																				// fazendo o flood fill
			} else if (campo[celula.getLinha()][celula.getColuna()].isEmBranco() == false
					&& campo[celula.getLinha()][celula.getColuna()].isVisivel() == false) {
				campo[celula.getLinha()][celula.getColuna()].setVisivel(true);// se a célula não for bomba e não for
																				// vazia, ela torna-se visível
				celulasVisiveis++; // e o método é encerrado
			}
		}
	}

	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {// varre toda a matriz
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba() == false) {// acha as posições sem bomba
					for (int k = i - 1; k <= i + 1; k++) {// verifica as 8 casas vizinhas dessas posições
						if (k >= 0 && k < campo.length) {// condição que evita o ArrayOutOfBounds
							for (int l = j - 1; l <= j + 1; l++) {
								if (l >= 0 && l < campo.length) {
									if (campo[k][l].isBomba() == true) {// se o vizinho for bomba...
										campo[i][j].setQtdBombasVizinhas(campo[i][j].getQtdBombasVizinhas() + 1);
									} // ...o valor de bombas vizinhas é alterado e posteriormente impresso na célula
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean verificarGanhouJogo() {
		if (this.celulasVisiveis >= (this.campo.length * this.campo.length) - this.bombas) {// condição de vitória do
																							// jogador
			System.out.println("Você ganhou o jogo!!!");
			fimDeJogo = true;// determina o fim do jogo caso a condição seja satisfeita
			return this.ganhouJogo = true;// altera o valor de ganhouJogo, que será usado em iniciarJogo() da classe
											// CampoMinado

		} else {
			return this.ganhouJogo = false;
		}
	}

	public void percorrerVizinhos(Celula[][] campo) {// método auxiliar que permite inicializar buscarVizinhos(classe
														// Celula) na classe Mapa
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {// percorre uma única vez a matriz inteira e determina os vizinhos
													// de cada célula
				campo[i][j].buscarVizinhos(campo);
			}
		}
	}

	public Celula getCelula(int linha, int coluna) {
		return campo[linha][coluna]; // método que serve para padronizar os parâmetros do tipo Celula, como em
										// revelarEspacos
	} // além de deixar a linguagem mais natural

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

	public boolean isFimDeJogo() {
		return fimDeJogo;
	}

	public boolean isGanhouJogo() {
		return ganhouJogo;
	}

	public void setGanhouJogo(boolean ganhouJogo) {
		this.ganhouJogo = ganhouJogo;
	}

	public int getCelulasVisiveis() {
		return celulasVisiveis;
	}

	public void setCelulasVisiveis(int celulasVisiveis) {
		this.celulasVisiveis = celulasVisiveis;
	}

	public int getBombas() {
		return bombas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
	}

}
