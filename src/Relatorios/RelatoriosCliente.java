package Relatorios;

import java.util.Scanner;

public class RelatoriosCliente {
	
	Scanner input = new Scanner(System.in);
	int opcao;
	
	public void Menu() {
		
	System.out.println("Saldo");
	System.out.println("Tributa��o da Conta Corrente");
	System.out.println("Rendimento da Poupan�a");
	System.out.println("Seguro de Vida");
	opcao = input.nextInt();
	
	}
}
