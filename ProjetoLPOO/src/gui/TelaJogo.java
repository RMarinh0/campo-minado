package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.com.poli.projetocampominado.Jogador;
import jogo.*;
import mapa.*;
import java.awt.GridLayout;

public class TelaJogo extends JFrame {
	private JPanel contentPane;
	protected BotaoJogo botoes[][];
	JPanel panel = new JPanel();
	private Dificuldade dificuldade;
	private Mapa mapa;
	protected CampoMinado campoMinado;

	public TelaJogo(Dificuldade dificuldade) {
		this.campoMinado = new CampoMinado("FULANO", dificuldade);
		this.dificuldade = dificuldade;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(
				new GridLayout(campoMinado.getDificuldade().getValor(), campoMinado.getDificuldade().getValor()));
		criarBotoes();

	}

	/*
	 * ActionListener botaoSelecionado = new ActionListener() { public void
	 * actionPerformed(ActionEvent e) {
	 * 
	 * } }
	 */
	public int line;
	public int column;

	public void criarBotoes() {
		botoes = new BotaoJogo[campoMinado.getDificuldade().getValor()][campoMinado.getDificuldade().getValor()];
		for (line = 0; line < campoMinado.getDificuldade().getValor(); line++) {
			for (column = 0; column < campoMinado.getDificuldade().getValor(); column++) {
				botoes[line][column] = new BotaoJogo(line, column);
				if (campoMinado.getDificuldade().equals(Dificuldade.DIFICIL)) {
					botoes[line][column].setMargin(new Insets(0, 0, 0, 0));// <----------------------
					botoes[line][column].setFont(new Font("Tahoma", Font.BOLD, 9));
				}
				panel.add(botoes[line][column]);// os botões tão se comportando como se fossem o mesmo botão?			
					botoes[line][column].actionListenerBotao(this);
					
					
			}
		}
	}
	/*
	 * private void buttonHandler() {
	 * campoMinado.getMapa().escolherPosicao(this.getLine(),this.getColumn()); }
	 */

	public JButton[][] getBotoes() {
		return botoes;
	}

	public int getLine() {
		return this.line - 1;
	}

	public int getColumn() {
		return this.column - 1;
	}

}
