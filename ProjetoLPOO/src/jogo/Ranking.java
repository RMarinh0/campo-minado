package jogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import jogo.*;

public class Ranking {

	private static BufferedReader buffR;
	private static File arquivo;
	private static FileReader fileR;
	private static FileWriter fileW;
	private static BufferedWriter buffW;

	public static void escreverRanking(String nome, int tempo, Dificuldade dificuldade) {

		File arquivo = new File("RANKING.txt");
		switch (dificuldade) {
		case FACIL:
			arquivo = new File("RankingFacil.txt");
			break;
		case MEDIO:
			arquivo = new File("RankingMedio.txt");
			break;
		case DIFICIL:
			arquivo = new File("RankingDificil.txt");
			break;
		}
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fw);
			escrever.newLine();
			escrever.write(Integer.toString(tempo));
			escrever.newLine();
			escrever.write(nome);
			escrever.newLine();
			escrever.close();
			fw.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}



	public static JogadorRanking lerRanking(String arquivo) throws IOException {
		fileR = new FileReader(arquivo);
		buffR = new BufferedReader(fileR);
		JogadorRanking ranking = new JogadorRanking("fausto", 70);
		String linha;
		while ((linha = buffR.readLine()) != null) {
			linha = buffR.readLine();
			ranking.setTempo(Integer.parseInt(linha));
			linha = buffR.readLine();
			ranking.setNome(linha);
			ranking.adicionaJogador(ranking.getNome(),ranking.getTempo() );
		}
		Collections.sort(ranking.getDadosRanking());
		return ranking;

	}

	public static BufferedReader getBuffR() {
		return buffR;
	}

	public static void setBuffR(BufferedReader buffR) {
		Ranking.buffR = buffR;
	}

	public static FileReader getFileR() {
		return fileR;
	}

	public static void setFileR(FileReader fileR) {
		Ranking.fileR = fileR;
	}

	public static FileWriter getFileW() {
		return fileW;
	}

	public static void setFileW(FileWriter fileW) {
		Ranking.fileW = fileW;
	}

	public static BufferedWriter getBuffW() {
		return buffW;
	}

	public static void setBuffW(BufferedWriter buffW) {
		Ranking.buffW = buffW;
	}

	public static File getArquivo() {
		return arquivo;
	}

	public static void setArquivo(File arquivo) {
		Ranking.arquivo = arquivo;
	}
}

/*
 * public static void lerRanking(Dificuldade dificuldade) { try { //FileReader
 * ler = new FileReader("RANKING.txt"); switch(dificuldade) { case FACIL: ler =
 * new FileReader("RankingFácil.txt"); break; case MEDIO: ler = new
 * FileReader("RankingMédio.txt"); break; case DIFICIL: ler = new
 * FileReader("RankingDifícil.txt"); break; } lerBuffer = new
 * BufferedReader(ler); String linha = lerBuffer.readLine(); while (linha !=
 * null) { System.out.println(linha); linha = lerBuffer.readLine(); } } catch
 * (IOException ex) {
 * 
 * }
 * 
 * }
 * 
 * }
 */

/*
 * public static void escreverRanking(String nome, int tempo, Dificuldade
 * dificuldade) {
 * 
 * File arquivo = new File("RANKING.txt") switch (dificuldade) case FACIL:
 * arquivo = new File("RankingFácil.txt"); break; case MEDIO: arquivo = new
 * File("RankingMédio.txt"); break; case DIFICIL: arquivo = new
 * File("RankingDifícil.txt"); break; } try { try { if (!arquivo.exists()) {
 * arquivo.createNewFile(); } fileW = new FileWriter(arquivo, true); //if (nome
 * != null) { buffW.write(nome); buffW.newLine(); //} // if
 * (Integer.toString(tempo) != null) { buffW.write(Integer.toString(tempo));
 * buffW.newLine(); //} buffW.close(); } catch (NullPointerException e) {
 * System.out.println("MSG NULLPOINTER: " + e.getMessage());
 * System.out.println("NOME: " + nome + "\nTEMPO: " + tempo); } } catch
 * (IOException ex) { System.out.println(ex.getMessage()); } }
 */