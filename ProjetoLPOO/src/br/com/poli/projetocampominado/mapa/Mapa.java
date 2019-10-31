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
		// a seguir, a inicializa��o do array campo, utilizando os valores(tamanho) da respectiva
		// dificuldade como "i" e "j"
		this.campo = new Celula[tamanho][tamanho];
		// implementa��o dos m�todos no construtor da classe, com prop�sito de
		// agiliza��o
		this.bombas=bombas;
		inicializarCelulas();
		distribuirBombas(bombas);
		contarBombas();
		
	}

	public void imprimeTela(boolean teste) {
		//impress�o da matriz tamanhoxtamanho, com a express�o dos elementos dependendo do valor booleano "teste"
		if (teste == true) {
			for (int i = 0; i < campo.length; i++) {//se o teste for verdadeiro, o valor das c�lulas n�o ser� oculto,
				for (int j = 0; j < campo.length; j++) {//permitindo a checagem do bom funcionamento da matriz
					if (campo[i][j].isBomba() == false) {
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());//se n�o for bomba, imprime vazio ou
					} else {                                                       // o n� de bombas ao redor
						System.out.print(" B");
					}

				}
				System.out.println();
			}
		} else {//se o teste for falso, a matriz ser� impressa como se um jogo de verdade estiver acontecendo
			for (int i = 0; i < campo.length; i++) {
				for (int j = 0; j < campo.length; j++) {
					if(campo[i][j].isVisivel()==false)//se o elemento n�o for vis�vel, uma interroga��o ser�
					System.out.print(" ?");           //impressa em seu lugar
					else if(campo[i][j].isBomba()==true) 
						System.out.print(" B");
					else
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
				}//repeti��o dos comandos da condi��o an�loga, para que de qualquer forma as impress�es sejam satisfeitas
				System.out.println();
			}
		}
	}

	private void distribuirBombas(int bombas) {
		Random random = new Random();
		for (int i = 0; i < bombas; i++) {//a repeti��o do la�o e coloca��o das bombas depender� da dificuldade
			int x = random.nextInt(campo.length);// uma linha aleat�ria do array
			int y = random.nextInt(campo.length);// uma coluna aleat�ria do array
			// ou seja, um elemento [x][y] aleat�rio
			if (getCelula(x,y).isBomba() == false)
				getCelula(x,y).setBomba(true);// para cada percorrida do array, uma c�lula ter� seu valor de bomba convertido
			else                           // para "verdadeiro"
				i--;// garantia de que um mesmo elemento n�o ter� uma bomba posta em cima da outra
		}
	}

	private void inicializarCelulas() {//m�todo que preenche o campo com C�lulas
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(false, false, false, 0,0,0);//todas as c�lulas s�o inicializadas "zeradas",
			}                                                    //modifica��es em seus valores ao decorrer do c�digo
		}
	}

	public void escolherPosicao(int linha, int coluna) {//m�todo que permite ao jogador escolher o elemento da matriz
		                                                //em que deseja jogar
		if (campo[linha][coluna].isBomba() == true) {
			campo[linha][coluna].setVisivel(true);//se a posi��o escolhida for uma bomba, o jogo � "encerrado"
			this.fimDeJogo = true;
			System.out.println("FIM DE JOGO! VOC� PERDEU");
		} else if (campo[linha][coluna].isEmBranco()==false) {
			campo[linha][coluna].setVisivel(true);//se a posi��o tiver bombas ao redor, ela � revelada contendo o n�mero
			                                      //de bombas ao redor
			celulasVisiveis++;
		} else if (campo[linha][coluna].isEmBranco()==true) {
			revelarEspacos(linha, coluna);//se a posi��o for vazia, o m�todo revelarEspacos � acionado, usando recursividade
		}                               //para revelar todos os vazios em volta, e parar quando achar uma n�o vazia que
		                                //n�o seja uma bomba
		imprimeTela(false);//ao final do m�todo, a tela ser� impressa novamente com os valores atualizados, deixando os inalterados invis�veis
		verificarGanhouJogo();
		System.out.println(celulasVisiveis);
	}       

	public void revelarEspacos(int i, int j) { //checar as posi��es vizinhas da posi��o escolhida(caso ela seja vazia)
		for (int k = i - 1; k <= i + 1; k++) {//verificando as 8 casas em volta do elemento vazio da matriz,
			if (k >= 0 && k < campo.length) { //fazendo adequadamente o flood fill dos vizinhos vazios
				for (int l = j - 1; l <= j + 1; l++) {
					if (l >= 0 && l < campo.length) {
						if (campo[k][l].isEmBranco()==true&& campo[k][l].isVisivel() == false) {
							campo[k][l].setVisivel(true);
							celulasVisiveis++;
							//campo[k][l].buscarVizinhos(campo);
							revelarEspacos(k, l);//se o vizinho do elemento vazio tamb�m for vazio, ele torna-se vis�vel
						}                      //e o m�todo � acionado novamente, mas em fun��o desse vizinho vazio
						else if(campo[k][l].isEmBranco()==false && campo[k][l].isVisivel()==false) {
							campo[k][l].setVisivel(true);//se o vizinho n�o for vazio e n�o for bomba, ele simplesmente torna-se vis�vel e a checagem � encerrada
							celulasVisiveis++;
						}                                
					}
				}
			}
		}
	}

	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {//varre toda a matriz	
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba() == false) {//acha as posi��es sem bomba
					for (int k = i - 1; k <= i + 1; k++) {//verifica as 8 casas vizinhas dessas posi��es
						if (k >= 0 && k < campo.length) {//condi��o que evita o ArrayOutOfBounds
							for (int l = j - 1; l <= j + 1; l++) {
								if (l >= 0 && l < campo.length) {
									if (campo[k][l].isBomba() == true) {//se o vizinho for bomba...
										campo[i][j].setQtdBombasVizinhas(campo[i][j].getQtdBombasVizinhas() + 1);
									} //...o valor de bombas vizinhas � alterado e posteriormente impresso na c�lula
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean verificarGanhouJogo() {
		if(this.celulasVisiveis>=(this.campo.length*this.campo.length)-this.bombas)
		{   
			System.out.println("Voc� ganhou o jogo!!!");
			return this.ganhouJogo=true;
		}
		else{
			return this.ganhouJogo=false;
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
