package ContasBancarias;

public class ContaPoupanca extends Conta implements taxas{
	
	private int qtdSaque = 0, qtdDeposito = 0, qtdTransferencia = 0;
		
	public ContaPoupanca(String cpf, double saldo, int agencia, String tipo) {
		super(cpf, saldo, agencia, tipo);
	}
	
	@Override
	public boolean Sacar (double valor) {
		if(this.getSaldo()>=valor + TAXASAQUE) {
		double saque = this.getSaldo() - valor - TAXASAQUE;
		this.setSaldo(saque);
		this.qtdSaque++;
		return true;
		}
			System.out.println("Saldo insuficiente.");
			return false;
	}
	@Override
	public boolean Depositar (double valor) {
		double deposite = this.getSaldo() + valor - TAXADEPOSITO;
		this.setSaldo(deposite);
		this.qtdDeposito++;
		return true;
	}
	@Override
	public void DepositarTransferencia (double valor) {
		double deposite = this.getSaldo() + valor;
		this.setSaldo(deposite);
	}
	@Override
	public boolean Transferir (Conta Destino, double valor) {
		if (this.getSaldo() >= valor + TAXATRANSFERENCIA) {
			this.Sacar(valor + TAXASAQUE);
			Destino.DepositarTransferencia(valor);
			this.qtdTransferencia++;
			return true;
		}
			System.out.println("Saldo insuficiente.");
			return false;
	}

	public int getQtdSaque() {
		return qtdSaque;
	}

	public int getQtdDeposito() {
		return qtdDeposito;
	}

	public int getQtdTransferencia() {
		return qtdTransferencia;
	}

}
