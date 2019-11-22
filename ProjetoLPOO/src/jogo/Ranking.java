package jogo;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class Ranking {
	public static String Read(String caminho) { // passar o endereço da pasta
		String conteudo = "";
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while(linha!=null) {
					conteudo += linha;
					linha = lerArq.readLine();
				}
				arq.close();
			} catch (IOException ex) {
				conteudo = "Erro: Não foi possível ler o arquivo";
			}
		} catch(FileNotFoundException ex) {
			conteudo = "Erro: Arquivo não encontrado";
		}
		if(conteudo.contains("Erro"))
			return "";
		else 
			return conteudo;
	}
	 public static boolean Write(String caminho, String texto) {
		try {
			FileWriter arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(texto);
			gravarArq.close();
			return true;
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	 }
}
