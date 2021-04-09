package Banco;

import java.util.ArrayList;
import java.util.TreeMap;

public class AgenciaBancaria {
	private TreeMap<String, Cliente> clientes;
	private ArrayList<Conta> contas;
	private int proximoId = 0;
	
	public AgenciaBancaria() {
		this.clientes = new TreeMap<>();
		this.contas = new ArrayList<>();
	}
	
	public Conta getConta(int id) {
		for (Conta conta : contas) {
			if (conta.getId() == id) {
				return conta;
			}else {
				throw new RuntimeException("Conta não encontrada");
			}
		}
		return null;
	}
	
	public void addCliente(String id) {
		if (clientes.containsKey(id)) {
			throw new RuntimeException("Cliente: " + id + " já está cadastrado");
		}else {
			Cliente c1 = new Cliente(id);
			this.clientes.put(id, c1);
			c1.getContas().add(new ContaCorrente(proximoId, id));
			this.proximoId += 1;
			c1.getContas().add(new ContaPoupanca(proximoId, id));
			this.proximoId += 1;
			this.contas.addAll(c1.getContas());
			System.out.println("Cliente adicionado com sucesso");
			
		}
		
		
	}
	
	public void sacar(int idConta, double valor ) {
		for (Conta conta : contas) {
			if (conta.id == idConta) {
				conta.sacar(valor);
				return;
			}
		}
		throw new RuntimeException("Cliente não encontrado");
	}
	
	public void depositar(int idConta, double valor ) {
		for (Conta conta : contas) {
			if (conta.id == idConta) {
				conta.depositar(valor);
				System.out.println("Deposito realizado com sucesso");
				return;
			}
		}
		
		throw new RuntimeException("Cliente não encontrado");
	}
	
	public void atualizar() {
		for (Conta conta : contas) {
			conta.atualizar();
		}
	}
	
	public void transferir(int contaOrigem, int contaDestino, double valor) {
		boolean acharOrigem = false;
		boolean acharDestino = false;
		if (contaDestino == contaOrigem) {
			throw new RuntimeException("As contas não podem ser iguais");
		}else {
			for (Conta conta : contas) {
				if (conta.id == contaOrigem) {
					acharOrigem = true;
				}
			}
			
			for (Conta conta : contas) {
				if (conta.id == contaDestino) {
					acharDestino = true;
				}
			}
			
			if (!acharDestino) {
				throw new RuntimeException("Conta de destino não existe");
			}else if (!acharOrigem) {
				throw new RuntimeException("Conta de origen não existe");
			}else {
				contas.get(contaOrigem).transferir(contas.get(contaDestino), valor);
			}
		}
	}
	
	public String toString() {
		String painel = "Clientes\n";
		for (Conta conta : contas) {
			painel += conta.toString() + "\n";
		}
		return painel;
	}
	
	

}
