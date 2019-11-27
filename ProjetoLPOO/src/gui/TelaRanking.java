package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import jogo.Ranking;
import javax.swing.JLabel;

public class TelaRanking extends JFrame {

	private JPanel contentPane;
	private Ranking ranking;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaRanking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRanking = new JLabel("RANKING");
		lblRanking.setForeground(new Color(232,218,0));
		lblRanking.setFont(new Font("LCDMono2", Font.BOLD, 18));
		lblRanking.setBounds(336, 11, 46, 14);
		contentPane.add(lblRanking);
		
		JTextArea dadosFacil = new JTextArea((String) null);
		dadosFacil.setForeground(new Color(232,218,0));
		dadosFacil.setBackground(new Color(0, 51, 102));
		try {
			dadosFacil.setText(Ranking.lerRanking("RankingFacil.txt").retornaJogador());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dadosFacil.setBounds(22, 57, 286, 191);
		dadosFacil.setFont(new Font("LCDMono2", Font.BOLD, 18));
		dadosFacil.setEditable(false);
		contentPane.add(dadosFacil);
		
		JTextArea dadosDificil = new JTextArea((String) null);
		dadosDificil.setForeground(new Color(232,218,0));
		dadosDificil.setBackground(new Color(0, 51, 102));
		dadosDificil.setFont(new Font("LCDMono2", Font.BOLD, 18));
		try {
			dadosDificil.setText(Ranking.lerRanking("RankingDificil.txt").retornaJogador());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dadosDificil.setBounds(211, 271, 286, 191);
		dadosDificil.setEditable(false);
		contentPane.add(dadosDificil);
		
		JTextArea dadosMedio = new JTextArea((String) null);
		dadosMedio.setForeground(new Color(232,218,0));
		dadosMedio.setBackground(new Color(0, 51, 102));
		dadosMedio.setFont(new Font("LCDMono2", Font.BOLD, 18));
		try {
			dadosMedio.setText(Ranking.lerRanking("RankingMedio.txt").retornaJogador());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dadosMedio.setBounds(394, 57, 286, 191);
		dadosMedio.setEditable(false);
		contentPane.add(dadosMedio);
		
		JLabel lblFacil = new JLabel("FACIL");
		lblFacil.setForeground(new Color(232,218,0));
		lblFacil.setFont(new Font("LCDMono2", Font.BOLD, 18));
		lblFacil.setBounds(130, 32, 46, 14);
		contentPane.add(lblFacil);
		
		JLabel lblDificil = new JLabel("DIFICIL");
		lblDificil.setForeground(new Color(232,218,0));
		lblDificil.setBounds(336, 250, 46, 14);
		lblDificil.setFont(new Font("LCDMono2", Font.BOLD, 18));
		contentPane.add(lblDificil);
		
		JLabel lblMedio = new JLabel("MEDIO");
		lblMedio.setForeground(new Color(232,218,0));
		lblMedio.setBounds(520, 32, 46, 14);
		lblMedio.setFont(new Font("LCDMono2", Font.BOLD, 18));
		contentPane.add(lblMedio);
	}
}
