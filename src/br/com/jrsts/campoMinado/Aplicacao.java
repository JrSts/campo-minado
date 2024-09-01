package br.com.jrsts.campoMinado;

import br.com.jrsts.campoMinado.Model.Tabuleiro;
import br.com.jrsts.campoMinado.View.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
		
		System.out.println(tabuleiro.toString());
	}

}
