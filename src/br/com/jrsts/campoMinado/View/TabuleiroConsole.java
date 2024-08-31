package br.com.jrsts.campoMinado.View;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.jrsts.campoMinado.Exception.SairException;
import br.com.jrsts.campoMinado.Model.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner scan = new Scanner(System.in);
	
	public TabuleiroConsole (Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		boolean continuar = true;
		
		try {
			while (continuar){
				cicloDoJogo();
				
				
				System.out.println("Outra partida? (S/n)");
				String resposta = scan.nextLine();
				if (resposta.equalsIgnoreCase("n")) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
				
			}
		} catch (SairException e) {
			System.out.println("Tchau!");
		}
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x, y): ");
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim()))
						.iterator();
				
				digitado = capturarValorDigitado("1 para Abrir\n2 para (Des)Marcar: ");
				
				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}
			System.out.println(tabuleiro);
			System.out.println("Você Ganhou!!!");
		} catch (Exception e) {
			System.out.println(tabuleiro);
			System.out.println("Você Perdeu!!");
		}
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = scan.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
}
