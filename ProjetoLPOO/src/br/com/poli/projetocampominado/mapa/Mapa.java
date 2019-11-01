package br.com.poli.projetocampominado.mapa;

import java.util.Random;

import br.com.poli.projetocampominado.Celula;
import br.com.poli.projetocampominado.Dificuldade;

public abstract class Mapa {
	private Celula[][] campo;
	// array do tipo celula
	private Dificuldade dificuldade;
	private int bombas;
	private boolean fimDeJogo;
	private boolean ganhouJogo;
	private int celulasVisiveis;

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
        percorrer(campo);
	    
		

	}

	public void imprimeTela(boolean teste) {
		// impressão da matriz tamanhoxtamanho, com a expressão dos elementos dependendo
		// do valor booleano "teste"
		if (teste == true) {
			for (int i = 0; i < campo.length; i++) {// se o teste for verdadeiro, o valor das células não será oculto,
				for (int j = 0; j < campo.length; j++) {// permitindo a checagem do bom funcionamento da matriz
					if (campo[i][j].isBomba() == false) {
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());// se não for bomba, imprime vazio ou
					} else { // o n° de bombas ao redor
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
						System.out.print(" -"); // impressa em seu lugar
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
												// convertido
			else // para "verdadeiro"
				i--;// garantia de que um mesmo elemento não terá uma bomba posta em cima da outra
		}
	}

	private void inicializarCelulas() {// método que preenche o campo com Células
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(/* false, false, false, 0, */i, j);// todas as células são inicializadas															// "zeradas",
			} // modificações em seus valores ao decorrer do código
		}
	}

	public void escolherPosicao(int linha, int coluna) {// método que permite ao jogador escolher o elemento da matriz
														// em que deseja jogar
		if (campo[linha][coluna].isBomba() == true) {
			campo[linha][coluna].setVisivel(true);// se a posição escolhida for uma bomba, o jogo é "encerrado"
			System.out.println("Fim de Jogo! Você perdeu!");
			fimDeJogo = true;
		} else if (campo[linha][coluna].isEmBranco() == false) {
			campo[linha][coluna].setVisivel(true);// se a posição tiver bombas ao redor, ela é revelada contendo o
													// número
													// de bombas ao redor
			celulasVisiveis++;
		} else if (campo[linha][coluna].isEmBranco() == true) {
			revelarEspacos(getCelula(linha, coluna));// se a posição for vazia, o método revelarEspacos é acionado,
														// usando recursividade
		} // para revelar todos os vazios em volta, e parar quando achar uma não vazia que
			// não seja uma bomba
		imprimeTela(false);// ao final do método, a tela será impressa novamente com os valores
							// atualizados, deixando os inalterados invisíveis
		verificarGanhouJogo();
	}

	public void revelarEspacos(Celula celulaEscolhida) { // checar as posições vizinhas da posição escolhida(caso ela
															// seja vazia)
		for (Celula celula : celulaEscolhida.getVizinhos()) {
			if (campo[celula.getLinha()][celula.getColuna()].isEmBranco() == true
					&& campo[celula.getLinha()][celula.getColuna()].isVisivel() == false) {
				campo[celula.getLinha()][celula.getColuna()].setVisivel(true);
				celulasVisiveis++;
				revelarEspacos(campo[celula.getLinha()][celula.getColuna()]);
			}
			else if(campo[celula.getLinha()][celula.getColuna()].isEmBranco()==false 
					&& campo[celula.getLinha()][celula.getColuna()].isVisivel() == false){
				campo[celula.getLinha()][celula.getColuna()].setVisivel(true);
				celulasVisiveis++;
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
		if (this.celulasVisiveis >= (this.campo.length * this.campo.length) - this.bombas) {
			System.out.println("Você ganhou o jogo!!!");
			fimDeJogo = true;
			return this.ganhouJogo = true;
		} else {
			return this.ganhouJogo = false;
		}
	}
	
	public void percorrer(Celula[][] campo) {
		for(int i = 0; i<campo.length; i++) {
			for(int j=0; j<campo.length; j++) {
				campo[i][j].buscarVizinhos(campo);
			}
		}
	}

	public Celula getCelula(int linha, int coluna) {
		return campo[linha][coluna];
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
