package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BotaoJogo extends JButton {
	private int linha;
	private int coluna;

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
					tela.campoMinado.getMapa().getCelula(getLinha(), getColuna()).setBandeira(true);
					tela.botoes[getLinha()][getColuna()].setText("F");
				}
			}
		});
	}

	public void actionListenerBotao(TelaJogo tela) {
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (!tela.campoMinado.getMapa().getCelula(linha, coluna).isVisivel()) {
					if (tela.campoMinado.getMapa().getCelula(linha, coluna).isBomba()) {
						for (int i = 0; i < tela.campoMinado.getDificuldade().getValor(); i++) {
							for (int j = 0; j < tela.campoMinado.getDificuldade().getValor(); j++) {
								tela.campoMinado.getMapa().getCelula(i, j).setVisivel(true);

							}
						}

						printarBotoesCelula(tela);

						JOptionPane.showMessageDialog(null, "Fim de Jogo! Você perdeu!");
						tela.dispose();
						Menu menu = new Menu();
						menu.setVisible(true);
					} else {
						tela.campoMinado.getMapa().escolherPosicao(linha, coluna);
						printarBotoesCelula(tela);

					}

				}

			}

		});
	}

	/*
	 * public void setarBandeiras(TelaJogo tela) {
	 * 
	 * for ( linha = 0; linha < tela.campoMinado.getDificuldade().getValor();
	 * linha++) { for ( coluna = 0; coluna <
	 * tela.campoMinado.getDificuldade().getValor(); coluna++) {
	 * tela.botoes[getLinha()][getColuna()].addMouseListener(new MouseAdapter(){
	 * public void MousePressed(MouseEvent e) {
	 * if(SwingUtilities.isRightMouseButton(e)) {
	 * tela.campoMinado.getMapa().getCelula(getLinha(),
	 * getColuna()).setBandeira(true);
	 * tela.botoes[getLinha()][getColuna()].setText("F"); } } }); } } }
	 */

	public void printarBotoesCelula(TelaJogo tela) {
		for (int i = 0; i < tela.campoMinado.getDificuldade().getValor(); i++) {
			for (int j = 0; j < tela.campoMinado.getDificuldade().getValor(); j++) {
				if (tela.campoMinado.getMapa().getCelula(i, j).isVisivel()) {
					if (!tela.campoMinado.getMapa().getCelula(i, j).isBomba()) {
						tela.botoes[i][j].setText(
								Integer.toString(tela.campoMinado.getMapa().getCelula(i, j).getQtdBombasVizinhas()));
					} else {
						tela.botoes[i][j].setText("B");
					}
					tela.botoes[i][j].setEnabled(false);
				}
			}
		}
		tela.campoMinado.getMapa().verificarGanhouJogo();
		if (tela.campoMinado.getMapa().isGanhouJogo()) {
			JOptionPane.showMessageDialog(null, "Boa corno!");
			tela.dispose();
			Menu menu = new Menu();
			menu.setVisible(true);
		}
		// setarBandeiras(tela);

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
