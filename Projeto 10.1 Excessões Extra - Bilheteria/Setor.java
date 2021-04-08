package Bilheteria;

public class Setor {
	private String nomeSetor;
	private double preco;
	private int qtd;
	private int capacidade;
	
	public Setor(String nome, double preco, int capacidade) {
		this.nomeSetor = nome;
		this.preco = preco;
		this.capacidade = capacidade;
		this.qtd = 0;
	}
	
	public String getNome() {
		return nomeSetor;
	}
	
	public int getQtd() {
		return qtd;
	}


	public double getPreco() {
		return preco;
	}

	public int getCapacidade() {
		return capacidade;
	}
	
	public boolean eventoLotado() {
		if (qtd == capacidade) {
			return true;
		}else {
			return false;
		}
	}

	public void vender() {
		if (!eventoLotado()) {
			this.qtd += 1;
		}
		
	}
	
	public String toString() {
		return nomeSetor + ": R$" + preco + ": " + qtd + "/" + capacidade;
	}

}
