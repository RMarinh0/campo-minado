package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import mapa.*;
import jogo.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField = new JTextField(10);
	private Dificuldade dificuldade = Dificuldade.FACIL;
	private TelaJogo tela;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu() {
		setTitle("Campo Minado - Arthur Falc\u00E3o & Rafael Marinho");
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setBackground(new Color(0, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCampoMinado = new JLabel("CAMPO MINADO");
		lblCampoMinado.setForeground(Color.YELLOW);
		lblCampoMinado.setBackground(Color.YELLOW);
		lblCampoMinado.setFont(new Font("LCDMono2", Font.PLAIN, 53));
		lblCampoMinado.setBounds(210, 59, 335, 92);
		contentPane.add(lblCampoMinado);

		JLabel lblJogador = new JLabel("JOGADOR");
		lblJogador.setForeground(Color.YELLOW);
		lblJogador.setFont(new Font("LCDMono2", Font.BOLD, 18));
		lblJogador.setBounds(326, 178, 70, 37);
		contentPane.add(lblJogador);
	

		JTextField nome = new JTextField();
		nome.setFont(new Font("LCDMono2", Font.BOLD, 18));
		nome.setBounds(289, 231, 146, 26);
		contentPane.add(nome);
		nome.setColumns(10);
		
		

		JLabel lblDificuldade = new JLabel("DIFICULDADE");
		lblDificuldade.setForeground(Color.YELLOW);
		lblDificuldade.setFont(new Font("LCDMono2", Font.BOLD, 18));
		lblDificuldade.setBounds(308, 309, 110, 26);
		contentPane.add(lblDificuldade);

		JButton btnRanking = new JButton("RANKING");
		btnRanking.setForeground(Color.BLACK);
		btnRanking.setFont(new Font("LCDMono2", Font.BOLD, 18));
		btnRanking.setBounds(303, 531, 115, 29);
		contentPane.add(btnRanking);

		
		JComboBox comboBoxDificuldade = new JComboBox();
		comboBoxDificuldade.setFont(new Font("LCDMono2", Font.BOLD, 16));
		comboBoxDificuldade.setModel(new DefaultComboBoxModel(new String[] { "Facil", "Medio", "Dificil" }));
		comboBoxDificuldade.setToolTipText("");
		comboBoxDificuldade.setBounds(298, 351, 120, 26);
		contentPane.add(comboBoxDificuldade);
		JButton btnJogar = new JButton("JOGAR");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxDificuldade.getSelectedIndex() != -1) {
					if (comboBoxDificuldade.getSelectedIndex() == 0) {
						tela = new TelaJogo(Dificuldade.FACIL);
					} else if (comboBoxDificuldade.getSelectedIndex() == 1) {
						tela = new TelaJogo(Dificuldade.MEDIO);
					} else if (comboBoxDificuldade.getSelectedIndex() == 2) {
						tela = new TelaJogo(Dificuldade.DIFICIL);
					}
				}
				tela.setVisible(true);
				String nomeJog = nome.getText(); 
				tela.campoMinado.getJogador().setNome(nomeJog);		
				dispose();
			}
		})

		;
		btnJogar.setForeground(Color.BLACK);
		btnJogar.setFont(new Font("LCDMono2", Font.BOLD, 18));
		btnJogar.setBounds(303, 452, 115, 29);
		contentPane.add(btnJogar);
		dispose();
		
	}
	
	
	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}


	
}
