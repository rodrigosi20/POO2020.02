package Bilheteria;

public class Venda {
	private Pessoa cliente;
	private Evento evento;
	private Setor setor;
	private double valor;
	
	public Venda(Pessoa cliente, Evento evento, Setor setor, double valor) {
		this.cliente = cliente;
		this.evento = evento;
		this.setor = setor;
		this.valor = valor;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public Setor getSetor() {
		return setor;
	}
	
	public String toString() {
		return cliente + ", " + evento + ", " + setor + ", R$" + valor;
	}
	
	

}
