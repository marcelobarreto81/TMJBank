package Relatorios;

import java.util.Scanner;

import ContasBancarias.Conta;
import ContasBancarias.ContaCorrente;
import ContasBancarias.taxas;

public class RelatoriosCliente {
	Scanner input = new Scanner(System.in);
	
	public void tributacao(Conta conta) {
		double qtdSaque = ((ContaCorrente)conta).getQtdSaque();
		double qtdDeposito = ((ContaCorrente)conta).getQtdDeposito();
		double qtdTransferencia = ((ContaCorrente)conta).getQtdTransferencia();
		double totalGastos = (qtdSaque*taxas.TAXASAQUE)+(qtdDeposito*taxas.TAXADEPOSITO)+(qtdTransferencia*taxas.TAXATRANSFERENCIA);
		
		
		System.out.println("Gastos totais com taxas: "+totalGastos);
		
		System.out.println("Quantidade de Saques: "+qtdSaque);
		System.out.println("Total de taxas para saque: "+qtdSaque*taxas.TAXASAQUE);
		
		System.out.println("Quantidade de Dep�sitos: "+qtdDeposito);
		System.out.println("Total de taxas para dep�sito: "+qtdDeposito*taxas.TAXADEPOSITO);
		
		System.out.println("Quantidade de transfer�ncia: "+qtdTransferencia);
		System.out.println("Total de taxas para trasnfer�ncia: "+qtdTransferencia*taxas.TAXATRANSFERENCIA);
		
		System.out.println("**Valor das Taxas**");
		System.out.println("Taxa para saque: "+taxas.TAXASAQUE);
		System.out.println("Taxa para dep�sito: "+taxas.TAXADEPOSITO);
		System.out.println("Taxa para transfer�ncia: "+taxas.TAXATRANSFERENCIA);
		
		if(((ContaCorrente)conta).isTemSeguro()) {
			double valorSegurado = ((ContaCorrente)conta).getValorSeguro();
			System.out.println("Valor do seguro de vida contratado: " +valorSegurado );
			System.out.println("Taxa debitada no ato da contrata��o: " +valorSegurado*taxas.TAXASEGUROVIDA);
		}
	}
	
	public void rendimento() {
		double valor;
		int prazo;
		double rendimento;
		
		System.out.println("Simula��o de investimento em Poupan�a");
		System.out.println("Digite o valor desejado: ");
		valor = input.nextDouble();
		System.out.println("Digite o prazo do investimento em dias: ");
		prazo = input.nextInt();
		
		rendimento = taxas.TAXARENDIMENTOPOUPANCA * prazo * valor;
		
		System.out.println("Rendimento ap�s "+prazo+" dias: " +rendimento);	
		
	}	
}
