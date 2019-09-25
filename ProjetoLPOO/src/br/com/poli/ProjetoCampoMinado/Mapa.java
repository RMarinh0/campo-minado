package br.com.poli.ProjetoCampoMinado;
import java.util.Random;
public class Mapa {
   private int [] [] campo;
   private Dificuldade dificuldade;
   
   public Mapa(Dificuldade dificuldade) {
	   this.dificuldade = dificuldade;
	   this.campo = new int [dificuldade.getValor()][dificuldade.getValor()];
	   this.inicializaCampo();
	   this.imprimeTela();
   }
   
   
   public void inicializaCampo() {
	   Random random = new Random();
	   for(int i=1;i<=10;i++) {
		   int x = random.nextInt(dificuldade.getValor());
		   int y = random.nextInt(dificuldade.getValor());
		   if (campo[x][y] == 0) 
			   campo [x][y] = -1;
		   else i--;
	   }
   }
   
   public void imprimeTela() {
	   for (int i=0; i<=dificuldade.getValor()-1; i++) {
		   for (int j=0; j<=dificuldade.getValor()-1; j++) {
			   if(campo[i][j]==-1) {
				   System.out.print(campo[i][j]+" ");
			   }
			   else {
				   System.out.print(campo[i][j]+"0 ");
			   }
		   }
		   System.out.println();
	   }
   }
}
