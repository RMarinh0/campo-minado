package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.BreakIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import jogo.Ranking;
import jogo.Dificuldade;
import jogo.Jogador;

public class BotaoJogo extends JButton {
	private int linha;
	private int coluna;
	private ImageIcon bomba = new ImageIcon(".\\images\\409bomb_100833.png");
	private ImageIcon bandeira = new ImageIcon(".\\images\\flag-yellow256_24951.png");
	private ImageIcon bombadificil = new ImageIcon(".\\images\\bombadificil");
	private ImageIcon bandeiradificil = new ImageIcon(".\\images\\bandeiradificil");
	// private Ranking ranking;

	// botao(linha,coluna)=celula(linha,coluna);
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
							tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).setBandeira(true);
							if (tela.campoMinado.getDificuldade() == Dificuldade.DIFICIL) {
								tela.botoes[getLinha()][getColuna()].setIcon(bandeiradificil);
							} else {
								tela.botoes[getLinha()][getColuna()].setIcon(bandeira);
							}
							tela.botoes[getLinha()][getColuna()].setEnabled(false);
						} else {
							tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).setBandeira(false);
							tela.botoes[getLinha()][getColuna()].setIcon(new ImageIcon(""));
							tela.botoes[getLinha()][getColuna()].setEnabled(true);
						}
					}
				}
			}

		});
	}

	public void actionListenerBotao(TelaJogo tela) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Chamo aqui!
				if (!tela.isExecutado()) {
					primeiraPosicao(tela);
					tela.setExecutado(true);
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

//BORA PORRA
	public void primeiraPosicao(TelaJogo tela) {
		// TÁ FUNCIONANDO CARAI
		// Menos se a posiçao for uma bomba
		if (!tela.campoMinado.getMapa().getCelula(linha, coluna).isEmBranco()
				|| tela.campoMinado.getMapa().getCelula(linha, coluna).isBomba()) {
			Dificuldade novaDificuldade = tela.campoMinado.getDificuldade();
			String novoJogador = tela.campoMinado.getJogador().getNome();
			tela.dispose();
			TelaJogo tela2 = new TelaJogo(novaDificuldade);
			tela2.campoMinado.getJogador().setNome(novoJogador);
			tela2.setVisible(true);
			// if(!tela2.campoMinado.getMapa().getCelula(linha, coluna).isBomba())
			tela2.campoMinado.getMapa().escolherPosicao(linha, coluna);
			printarBotoesCelula(tela2);
			primeiraPosicao(tela2);
			tela.setExecutado(true);
		} else
			tela.setExecutado(true);
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
			if (tela.campoMinado.getJogador().getNome() != null)
				Ranking.escreverRanking(tela.campoMinado.getJogador().getNome(),
						tela.campoMinado.getJogador().getTempo(), tela.campoMinado.getDificuldade());
			Ranking.lerRanking(tela.campoMinado.getDificuldade());
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