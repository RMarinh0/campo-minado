package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import jogo.*;
import mapa.*;

public class TelaJogo extends JFrame {
	private JPanel contentPane;
	protected BotaoJogo botoes[][];
	JPanel panel = new JPanel();
	private Dificuldade dificuldade;
	private Mapa mapa;
	protected CampoMinado campoMinado;

	public TelaJogo(Dificuldade dificuldade) {
		this.campoMinado = new CampoMinado(dificuldade);
		this.dificuldade = dificuldade;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 800, 760);
		setTitle("Campo Minado || Arthur Falcão e Rafael Marinho)");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(
		new GridLayout(campoMinado.getDificuldade().getValor(), campoMinado.getDificuldade().getValor()));
		criarBotoes();
		//keyListener();
	}
 
	
	public int line;
	public int column;

	
	
	public void criarBotoes() {
		botoes = new BotaoJogo[campoMinado.getDificuldade().getValor()][campoMinado.getDificuldade().getValor()];
		
		for (line = 0; line < campoMinado.getDificuldade().getValor(); line++) {
			for (column = 0; column < campoMinado.getDificuldade().getValor(); column++) {
				botoes[line][column] = new BotaoJogo(line, column);
				botoes[line][column].setBackground(new Color(0, 51, 102));
				botoes[line][column].setFont(new Font("LCDMono2", Font.BOLD, 25));
				if (campoMinado.getDificuldade().equals(Dificuldade.DIFICIL)) {
					botoes[line][column].setMargin(new Insets(0, 0, 0, 0));
					botoes[line][column].setFont(new Font("LCDMono2", Font.BOLD, 10));
					
				}
				else if (campoMinado.getDificuldade().equals(Dificuldade.MEDIO)) {
					botoes[line][column].setMargin(new Insets(0, 0, 0, 0));
					botoes[line][column].setFont(new Font("LCDMono2", Font.BOLD, 20));
					
				} 	
				panel.add(botoes[line][column]);
				botoes[line][column].mouseListener(this);
				botoes[line][column].actionListenerBotao(this);
			}
		}
	}
	
	/*public void keyListener() {
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					dispose();
					Menu menu = new Menu();
					menu.setVisible(true);
				}
			}
		});
	}*/


}
