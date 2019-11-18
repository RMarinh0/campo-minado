package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.projetocampominado.Jogador;
import jogo.*;
import mapa.*;
import java.awt.GridLayout;

public class TelaJogo extends JFrame  {
	private JPanel contentPane;
	private JButton botoes[][];
	JPanel panel = new JPanel();
	private Dificuldade dificuldade;
	private Mapa mapa;
	private CampoMinado campoMinado;

	public TelaJogo(Dificuldade dificuldade) {
		this.campoMinado = new CampoMinado("FULANO", dificuldade);
		this.dificuldade = Dificuldade.FACIL;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		criarBotoes();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(campoMinado.getDificuldade().getValor(), campoMinado.getDificuldade().getValor()));

	}

	/*
	 * ActionListener botaoSelecionado = new ActionListener() { public void
	 * actionPerformed(ActionEvent e) {
	 * 
	 * } }
	 */
    private int line;
    private int column;
    

	public void criarBotoes() {
		botoes = new JButton[campoMinado.getDificuldade().getValor()][campoMinado.getDificuldade().getValor()];
		for ( line = 0; line < campoMinado.getDificuldade().getValor(); line++) {
			for ( column = 0; column < campoMinado.getDificuldade().getValor(); column++) {
				botoes[line][column] = new BotaoJogo(line, column);
				panel.add(botoes[line][column]);
				/*botoes[line][column].addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonHandler();
					}
				});*/
			}
		}
	}
/*private void buttonHandler() {
	mapa.escolherPosicao(this.getLine(),this.getColumn());
}*/
	
	public JButton[][] getBotoes() {
		return botoes;
	}

	public void setBotoes(JButton[][] botoes) {
		this.botoes = botoes;
	}

	public int getLine() {
		return this.line;
	}
	public int getColumn() {
		return this.column;
	}



	
}
