package Tarifas;

public class Operação {

	public int id;
	public String descricao;
	public double valor;
	public double saldo;
	
	public Operação(String descricao, double valor, double saldo) {
		this.descricao = descricao;
		this.valor = valor;
		this.saldo = saldo;
		
	}
	
	public String toString() {
		return id + ":" + descricao + ":" + valor + ":" + saldo;
	}

}
