package jogo;

import java.util.ArrayList;
import java.util.List;

public class JogadorRanking implements Comparable<JogadorRanking> {
	private String nome;
	private int tempo;
	private List<JogadorRanking> dadosRanking = new ArrayList<JogadorRanking>();

	public JogadorRanking(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}

	public void adicionaJogador(String nome, int tempo) {
		dadosRanking.add(new JogadorRanking(nome, tempo));
	}
	@Override
	public int compareTo(JogadorRanking jogador2) {
		if (this.tempo < jogador2.tempo) {
            return -1;
        }
        if (this.tempo > jogador2.tempo) {
            return 1;
        }
        return 0;
    }

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public List<JogadorRanking> getDadosRanking() {
		return dadosRanking; 
	}

	public void setDadosRanking(List<JogadorRanking> dadosRanking) {
		this.dadosRanking = dadosRanking;
	}

	public String retornaNome() {
		String texto = "";
		for (JogadorRanking jogador : dadosRanking) {
			texto += jogador.getNome() + "\n";
		//	System.out.println("iterando o for(retornaNome) " + jogador.getNome());
		}
		return texto;
	}

	public String retornaTempo() {
		String tempo = "";
		for (JogadorRanking jogador : dadosRanking) {
			tempo += Integer.toString(jogador.getTempo()) + "\n";
		//	System.out.println("iterando o for(retornaTempo) "+jogador.getTempo());
		}
		return tempo;
	}
	
	public String retornaJogador() {
		String dados ="";
		for(JogadorRanking jogador: dadosRanking) {
			dados+=jogador.getNome()+": "+jogador.getTempo()+" segundos\n";
		}
		return dados;
	}

}