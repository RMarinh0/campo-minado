package gui;

import javax.swing.JButton;

public class BotaoJogo extends JButton{
       private int linha;
       private int coluna;
       
       BotaoJogo(int linha, int coluna){
    	   this.linha=linha;
    	   this.coluna=coluna;
       }

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}
