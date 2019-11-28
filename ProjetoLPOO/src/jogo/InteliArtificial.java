package jogo;

import mapa.*;
import java.util.Random;

public class InteliArtificial {
	private Celula[][] campo;
	private int bombasNaoMarcadas = 0;
	private int bombasMarcadas = 0;
	public InteliArtificial(Celula celula, Mapa mapa) {
		this.rodarIA(celula, mapa);
	}
	public void rodarIA(Celula celula, Mapa mapa) {
		this.selecionaPosicao(celula, mapa);
	}

	public void setarBandeira(Celula celulaEscolhida, Mapa mapa) {
		int vizInvisiveis = 0;
		bombasRestantes(mapa);
		for (Celula celula : celulaEscolhida.getVizinhos()) {
			if (!celula.isVisivel())
				vizInvisiveis++;
		}
		if (vizInvisiveis == bombasNaoMarcadas) {
			for (Celula celula : celulaEscolhida.getVizinhos()) {
				if (!celula.isVisivel()) {
					celula.setBandeira(true);
				}
			}
		}
		for(Celula celula: celulaEscolhida.getVizinhos()) {
			if(celulaEscolhida.getQtdBombasVizinhas()==vizInvisiveis) {
				if(!celula.isVisivel())
					celula.setBandeira(true);
			}
		}
	}

	/*
	 * public void addBandeira(Celula celulaEscolhida, Mapa mapa) { int
	 * bombasVizinhas=0; int vizinhosInvisiveis=0; int bombasMarcadas=0; for(Celula
	 * celula: celulaEscolhida.getVizinhos()) {
	 * bombasVizinhas+=celula.
	 * getQtdBombasVizinhas();
	 * if(!celula.isVisivel())
	 * vizinhosInvisiveis++; } if(bombasVizinhas>vizinhosInvisiveis) {
	 * celulaEscolhida.setBandeira(true); bombasMarcadas++; } bombasNaoMarcadas =
	 * mapa.getBombas() - bombasMarcadas;
	 * 
	 * }
	 */
	public void bombasRestantes(Mapa mapa) {
		for (int i = 0; i < mapa.getCampo().length; i++) {
			for (int j = 0; j < mapa.getCampo().length; j++) {
				if (mapa.getCelula(i, j).isBandeira())
					bombasMarcadas++;
			}
		}
		bombasNaoMarcadas = mapa.getBombas() - bombasMarcadas;
	}
 
	public void selecionaPosicao(Celula celulaEscolhida, Mapa mapa) {		
		mapa.escolherPosicao(6, 6);
		if(mapa.getNumBandeiras()==celulaEscolhida.getQtdBombasVizinhas()) {
			for(Celula celula: celulaEscolhida.getVizinhos()) {
				if(!celula.isVisivel())
					mapa.escolherPosicao(celula.getLinha(), celula.getColuna());
			}
		}
		this.setarBandeira(celulaEscolhida, mapa);
	}

}
