package Banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int id, String ClienteId) {
		super(id, ClienteId);
		this.tipo = "CP";
	}
	@Override
	public void atualizar() {
		saldo += this.saldo * 0.01;		
	}
	
}
