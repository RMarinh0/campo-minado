package gui;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import jogo.*;
import mapa.*;
import javax.swing.JLabel;

public class TelaJogo extends JFrame {
	private JPanel contentPane;
	private JLabel cronometro;
	private int contador = 0;
	protected Timer tm;
	protected BotaoJogo botoes[][];
	JPanel panelmaior = new JPanel();
	JPanel panel = new JPanel();
	private Dificuldade dificuldade;
	private Mapa mapa;
	protected CampoMinado campoMinado;
	//private Ranking rankear;
	
	
	
	public TelaJogo(Dificuldade dificuldade) {
		this.campoMinado = new CampoMinado(dificuldade);
		this.dificuldade = dificuldade;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 778, 670);
		setTitle("Campo Minado || Arthur Falcão e Rafael Marinho ||");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(232,218,0));
		setContentPane(contentPane);
		contentPane.add(panelmaior, BorderLayout.CENTER);
		panelmaior.setLayout(null);
		panelmaior.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		setResizable(false);
		
		
		panel.setBounds(15, 54, 732, 560);
		panelmaior.add(panel);
		panel.setLayout(new GridLayout(campoMinado.getDificuldade().getValor(),campoMinado.getDificuldade().getValor()));
		
		
		criarBotoes();
		cronometro();
		cronometro.setForeground(new Color(232,218,0));
		cronometro.setFont(new Font("LCDMono2", Font.BOLD, 30));
		cronometro.setBounds(304, 0, 144, 48);
		panelmaior.add(cronometro);

	}
 
	boolean jaExecutado = false;

	public boolean isExecutado() {
		return this.jaExecutado;
	}
	void setExecutado(boolean pffunfa) {
		this.jaExecutado = pffunfa;
	}
	
	public int line;
	public int column;

	
	
	public void criarBotoes() {
		botoes = new BotaoJogo[campoMinado.getDificuldade().getValor()][campoMinado.getDificuldade().getValor()];

		
		for (line = 0; line < campoMinado.getDificuldade().getValor(); line++) {
			for (column = 0; column < campoMinado.getDificuldade().getValor(); column++) {
				botoes[line][column] = new BotaoJogo(line, column);
				botoes[line][column].setForeground(Color.YELLOW);
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
	public void cronometro() {
		cronometro = new JLabel();
		tm = new Timer();
		tm.scheduleAtFixedRate(new TimerTask() {
			@Override
		public void run() {
				contador++;
				int seg = contador % 60;
				int min = contador / 60;
				int hora = min / 60;
				min %= 60;
				cronometro.setText(String.format("%02d:%02d:%02d", hora,min,seg));
				campoMinado.getJogador().setTempo(contador);
			}		
		}, 1000 , 1000);
	//campoMinado.getJogador().setTempo(contador);
	}
	

	
}