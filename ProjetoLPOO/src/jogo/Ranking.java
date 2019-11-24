package jogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ranking {

	private static BufferedReader lerBuffer;
	private static File arquivo;
	private static FileReader ler;

	public static void escreverRanking(String nome, int tempo, Dificuldade dificuldade) {

		// File arquivo = new File("RANKING.txt");
		switch (dificuldade) {
		case FACIL:
			arquivo = new File("RankingF�cil.txt");
			break;
		case MEDIO:
			arquivo = new File("RankingM�dio.txt");
			break;
		case DIFICIL:
			arquivo = new File("RankingDif�cil.txt");
			break;
		}
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fw);
			escrever.write(nome + ": " + tempo);
			escrever.newLine();
			escrever.close();

			escrever.close();
			fw.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void lerRanking(Dificuldade dificuldade) {
		try {
			//FileReader ler = new FileReader("RANKING.txt");
			switch(dificuldade) {
			case FACIL:
				ler = new FileReader("RankingF�cil.txt");
				break;
			case MEDIO:
				ler = new FileReader("RankingM�dio.txt");
				break;
			case DIFICIL:
				ler = new FileReader("RankingDif�cil.txt");
				break;
			}
			lerBuffer = new BufferedReader(ler);
			String linha = lerBuffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = lerBuffer.readLine();
			}
		} catch (IOException ex) {

		}

	}

}