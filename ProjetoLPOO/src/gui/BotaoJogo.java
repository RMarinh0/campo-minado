package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import jogo.Ranking;
import jogo.Dificuldade;
import jogo.InteliArtificial;
import jogo.CampoMinado;


public class BotaoJogo extends JButton {
	private int linha;
	private int coluna;
	private ImageIcon bomba = new ImageIcon(".\\images\\409bomb_100833.png");
	private ImageIcon bandeira = new ImageIcon(".\\images\\flag-yellow256_24951.png");
	private ImageIcon bombadificil = new ImageIcon(".\\images\\bombadificil");
	private ImageIcon bandeiradificil = new ImageIcon(".\\images\\bandeiradificil");

	BotaoJogo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public void mouseListener(TelaJogo tela) {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e) == true) {
					if (!tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).isVisivel()) {
						if (!tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).isBandeira()) {
							if (tela.campoMinado.getMapa().getNumBandeiras() < tela.campoMinado.getMapa().getBombas()) {
								tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).setBandeira(true);
								tela.campoMinado.getMapa()
										.setNumBandeiras(tela.campoMinado.getMapa().getNumBandeiras() + 1);
								if (tela.campoMinado.getDificuldade() == Dificuldade.DIFICIL) {
									tela.botoes[getLinha()][getColuna()].setIcon(bandeiradificil);
								} else {
									tela.botoes[getLinha()][getColuna()].setIcon(bandeira);
								}
								tela.botoes[getLinha()][getColuna()].setEnabled(false);
							}
						} else {
							tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).setBandeira(false);
							tela.botoes[getLinha()][getColuna()].setIcon(new ImageIcon(""));
							tela.botoes[getLinha()][getColuna()].setEnabled(true);
							tela.campoMinado.getMapa()
									.setNumBandeiras(tela.campoMinado.getMapa().getNumBandeiras() - 1);
						}
					}
				}
			}

		});
	}

	public void ativarIA(TelaJogo tela) {
		tela.campoMinado.getMapa().escolherPosicao(6, 6);
		do {
			InteliArtificial ia = new InteliArtificial(tela.campoMinado.getMapa().getCelula(6, 6),
					tela.campoMinado.getMapa());
			printarBotoesCelula(tela);
		} while (!tela.campoMinado.getMapa().isGanhouJogo());
	}

	public void actionListenerBotao(TelaJogo tela) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!tela.isExecutado()) { // garantir que o método só seja chamado na primeira jogada
					primeiraPosicao(tela);
				} else {
					if (!tela.campoMinado.getMapa().getCelula(linha, coluna).isVisivel()) {
						if (tela.campoMinado.getMapa().getCelula(linha, coluna).isBomba()) {
							for (int i = 0; i < tela.campoMinado.getDificuldade().getValor(); i++) {
								for (int j = 0; j < tela.campoMinado.getDificuldade().getValor(); j++) {
									tela.campoMinado.getMapa().getCelula(i, j).setVisivel(true);
									tela.botoes[i][j].setForeground(Color.YELLOW);
								}
							}

							printarBotoesCelula(tela);
							tela.tm.cancel();
							JOptionPane.showMessageDialog(null,
									"Fim de Jogo, " + tela.campoMinado.getJogador().getNome() + "! Você perdeu!");
							tela.dispose();
							Menu menu = new Menu();
							menu.setVisible(true);

						} else {
							tela.campoMinado.getMapa().escolherPosicao(linha, coluna);
							printarBotoesCelula(tela);
						}
					}

				}

			}

		});
	}

	public void primeiraPosicao(TelaJogo tela) {// garantir que a primeira posição sempre será vazia
		if (!tela.campoMinado.getMapa().getCelula(linha, coluna).isEmBranco() // Caso a posição não seja em branco,
				|| tela.campoMinado.getMapa().getCelula(linha, coluna).isBomba()) {
			CampoMinado campo2 = new CampoMinado(tela.campoMinado.getDificuldade());// um novo campoMinado é gerado, que
																					// reseta
			campo2.getJogador().setNome(tela.campoMinado.getJogador().getNome()); // o tabuleiro até que a 1a posição
																					// seja vazia
			campo2.getMapa().escolherPosicao(linha, coluna);
			if (campo2.getMapa().getCelula(linha, coluna).isEmBranco() // caso a posição do novo tabuleiro seja vazia,
					&& !campo2.getMapa().getCelula(linha, coluna).isBomba()) {// setamos ele como o novo campoMinado a
																				// aparecer na tela
				tela.setCampoMinado(campo2);
				printarBotoesCelula(tela);
			} else
				primeiraPosicao(tela); // rodar novamente até que a 1a posição seja vazia
			tela.setExecutado(true);
		} else
			tela.setExecutado(true); // caso a posição já seja vazia, continuar o jogo normalmente
		tela.campoMinado.getMapa().escolherPosicao(linha, coluna);
		printarBotoesCelula(tela);
	}

	public void printarBotoesCelula(TelaJogo tela) {
		for (int i = 0; i < tela.campoMinado.getDificuldade().getValor(); i++) {
			for (int j = 0; j < tela.campoMinado.getDificuldade().getValor(); j++) {
				if (tela.campoMinado.getMapa().getCelula(i, j).isVisivel()) {
					if (!tela.campoMinado.getMapa().getCelula(i, j).isBomba()) {
						if (tela.campoMinado.getMapa().getCelula(i, j).isEmBranco()) {
							tela.botoes[i][j].setText("");
						} else {
							tela.botoes[i][j].setText(Integer
									.toString(tela.campoMinado.getMapa().getCelula(i, j).getQtdBombasVizinhas()));
						}
						tela.botoes[i][j].setBackground(Color.BLACK);
						tela.botoes[i][j].setIcon(new ImageIcon(""));

					} else {

						if (tela.campoMinado.getDificuldade() == Dificuldade.DIFICIL) {
							tela.botoes[i][j].setIcon(bombadificil);
						} else {
							tela.botoes[i][j].setIcon(bomba);
						}
						tela.botoes[i][j].setBackground(new Color(158, 0, 0));
					}
					tela.botoes[i][j].setEnabled(false);
				}
			}
		}
		tela.campoMinado.getMapa().verificarGanhouJogo();
		if (tela.campoMinado.getMapa().isGanhouJogo()) {
			tela.tm.cancel();
			Ranking.escreverRanking(tela.campoMinado.getJogador().getNome(), tela.campoMinado.getJogador().getTempo(),
					tela.campoMinado.getDificuldade());
			JOptionPane.showMessageDialog(null,
					"Parabéns " + tela.campoMinado.getJogador().getNome() + "! Você venceu!");
			tela.dispose();
			Menu menu = new Menu();
			menu.setVisible(true);
		}
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