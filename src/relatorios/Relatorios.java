package relatorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import ContasBancarias.Conta;
import ContasBancarias.ContaCorrente;
import ContasBancarias.taxas;
import Pessoal.Pessoa;
import Principal.VerificaListas;

public class Relatorios {
	Scanner input = new Scanner(System.in);
	VerificaListas verifica = new VerificaListas();
	
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
	
	public void gerente(List<Conta> listaConta, Conta conta) {
		int contasNaAgencia = 0;
		int agencia = conta.getAgencia();
		
		for(int i = 0; i < listaConta.size(); i++) {
			if(agencia == listaConta.get(i).getAgencia())
				contasNaAgencia++;
		}
		System.out.println("Numeros de Contas da ag�ncia: " +contasNaAgencia);
		
	}
	
	public void diretor(List<Conta> listaConta, List<Pessoa> listaPessoa) {
		List<String> lista = new  ArrayList<>();
		for(int i = 0; i < listaConta.size(); i++) {
			String cpf = listaConta.get(i).getCpf();
			int agencia = listaConta.get(i).getAgencia();
			String nome = verifica.encontraPessoa(cpf, listaPessoa);
			String linha = "\n**************************\nNome: "+nome +"\nCPF:"+cpf+"\nAg�ncia:"+agencia;
			lista.add(linha);
		}
		Collections.sort(lista);
		System.out.println(lista);
	}	
	
	public void presidente(List<Conta> listaConta) {
		double capitalTotal = 0;
		for(int i = 0; i<listaConta.size(); i++) {
			capitalTotal += listaConta.get(i).getSaldo(); 
		}
		System.out.println("\n\n\n*****************************************");
		System.out.println("Capital Armazenado no Banco: "+capitalTotal);
		System.out.println("*****************************************");
	}
}













