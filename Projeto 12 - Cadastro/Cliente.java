package Banco;

import java.util.ArrayList;

public class Cliente {
	private String idCliente;
	private ArrayList<Conta> contas;
	
	public Cliente(String id) {
		this.idCliente = id;
		contas = new ArrayList<>();
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", contas=" + contas + "]";
	}
	
	
	
	

}
