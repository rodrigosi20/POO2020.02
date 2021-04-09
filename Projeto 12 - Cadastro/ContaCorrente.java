package Banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(int id, String ClienteId) {
		super(id, ClienteId);
		this.tipo = "CC";
	}
	
	@Override
	public void atualizar() {
		saldo -= 20;
	}
	
}
