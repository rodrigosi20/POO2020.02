package Tarifas;

public class Opera��o {

	public int id;
	public String descricao;
	public double valor;
	public double saldo;
	
	public Opera��o(String descricao, double valor, double saldo) {
		this.descricao = descricao;
		this.valor = valor;
		this.saldo = saldo;
		
	}
	
	public String toString() {
		return id + ":" + descricao + ":" + valor + ":" + saldo;
	}

}
