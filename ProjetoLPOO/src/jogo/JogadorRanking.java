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
		}
		return texto;
	}

	public String retornaTempo() {
		String tempo = "";
		for (JogadorRanking jogador : dadosRanking) {
			tempo += Integer.toString(jogador.getTempo()) + "\n";
		}
		return tempo;
	}
	
	public String retornaJogador() {
		String dados ="";
		for(JogadorRanking jogador: dadosRanking) {
			dados+=jogador.getNome()+": "+jogador.getTempo()+" segundos\n";
			if(dadosRanking.lastIndexOf(jogador)==4) {
				dadosRanking.remove(jogador);
				break;
			}
			else
				continue;
		}
		return dados;
	}
	public void printaConsole() {
		int i = 1;
		String dados = "";
		for(JogadorRanking jogador: dadosRanking) {
			dados = jogador.getNome()+": "+jogador.getTempo()+" segundos";
			System.out.printf("\n%dº lugar -> ",i);
			System.out.print(dados);
			i++;
			if(i==6)
				break;
		}
	}

}