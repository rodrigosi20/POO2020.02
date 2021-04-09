package Banco;

public abstract class Conta {
	protected int id;
	protected double saldo;
	protected String clienteId;
	protected String tipo;
	
	public Conta(int id, String ClienteId) {
		this.id = id;
		this.clienteId = ClienteId;
		this.saldo = 0;
	}
	
	public abstract void atualizar();
	
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new RuntimeException("Saldo insuficiente");
		}else {
			saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}
	}
	
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new RuntimeException("Valor inválido");
		}else {
			saldo += valor;
		}
	}
	
	public void transferir(Conta other, double valor) {
		if (this.saldo <= 0 || (this.saldo - valor) < 0) {
			throw new RuntimeException("Saldo insuficiente para transferir");
		}else{
			other.depositar(valor);
			this.saldo -= valor;
			System.out.println("Transferencia realizado com sucesso");
		}
	}

	public int getId() {
		return id;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getClienteId() {
		return clienteId;
	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return "Conta [ id = " + id + ", saldo = R$" + saldo + ", clienteId = " + clienteId + ", tipo = " + tipo + " ]";
	}
	
	

}
