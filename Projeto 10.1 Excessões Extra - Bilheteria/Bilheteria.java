package Bilheteria;

import java.util.ArrayList;
import java.util.TreeMap;

public class Bilheteria {
	private ArrayList<Venda> repVendas;
	private TreeMap<String, Pessoa> repPessoas;
	private TreeMap<String, Evento> repEvento;
	private double caixa;
	
	
	
	public Bilheteria() {
		repVendas = new ArrayList<>();
		repPessoas = new TreeMap<>();
		repEvento = new TreeMap<>();
		this.caixa = 0;
	}

	public boolean verificarExistencias(String nomeCliente, String nomeEvento, String nomeSetor) {
		if (!repPessoas.containsKey(nomeCliente)) {
			throw new RuntimeException("Falha: cliente " + nomeCliente + " não existe.");
		}else if (!repEvento.containsKey(nomeEvento)) {
			throw new RuntimeException("Falha: evento " + nomeEvento + " não existe.");
		}else if (!repEvento.get(nomeEvento).getRepSetores().containsKey(nomeSetor)) {
			throw new RuntimeException("Falha: setor " + nomeSetor + " não existe.");
		}
		
		return true;
	}
	
	public void vender(String nomeCliente, String nomeEvento, String nomeSetor) {
		if (!verificarExistencias(nomeCliente, nomeEvento, nomeSetor)) {
			verificarExistencias(nomeCliente, nomeEvento, nomeSetor);
		}else if(repEvento.get(nomeEvento).getRepSetores().get(nomeSetor).eventoLotado()) {
			throw new RuntimeException("O show está lotado");
		}else {
			double precoDoEvento = repEvento.get(nomeEvento).getRepSetores().get(nomeSetor).getPreco();
			if (repPessoas.get(nomeCliente).getMeia()) {
				precoDoEvento = repEvento.get(nomeEvento).getRepSetores().get(nomeSetor).getPreco() * 0.5;
			}
			
			repEvento.get(nomeEvento).getRepSetores().get(nomeSetor).vender();
			this.caixa += precoDoEvento;
			repVendas.add(new Venda(repPessoas.get(nomeCliente),repEvento.get(nomeEvento),repEvento.get(nomeEvento).getRepSetores().get(nomeSetor), precoDoEvento));
			System.out.println("Venda realizada com sucesso");
		}
	}

	public double getCaixa() {
		return caixa;
	}
	
	public String showVendas() {
		String painel = "";
		for (Venda venda : repVendas) {
			painel += venda.toString() + "\n";
		}
		
		return painel;
	}
	
	public String showPessoas() {
		String painel = "";
		for (Pessoa pessoas : repPessoas.values()) {
			painel += pessoas.toString() + "\n";
		}
		
		return painel;
	}
	
	public String showEventos() {
		String painel = "";
		for (Evento evento : repEvento.values()) {
			painel += evento.toString() + "\n";
		}
		
		return painel;
	}
	
	public void addPessoa(Pessoa pessoa) {
		if (!repPessoas.containsKey(pessoa.getNomePessoa())) {
			repPessoas.put(pessoa.getNomePessoa(), pessoa);
			System.out.println("Pessoa adicionada com sucesso");
		}else {
			throw new RuntimeException("Falha:" + " pessoa " + pessoa.getNomePessoa() + " já existe");
		}
		
	}
	
	public void addEvento(String nomeEvento) {
		if (!repEvento.containsKey(nomeEvento)) {
			repEvento.put(nomeEvento, new Evento(nomeEvento));
			System.out.println("Evento adicionado com sucesso");
		}else {
			throw new RuntimeException("Falha:" + " evento " + nomeEvento + " já existe");
		}
		
	}
	
	public void addSetor(String evento, String nomeSetor,double preco, int capacidade) {
		if (!repEvento.containsKey(evento)) {
			throw new RuntimeException("Falha: Evento não existe");
		}else if(repEvento.get(evento).getRepSetores().containsKey(nomeSetor)) {
			throw new RuntimeException("Falha: setor " + nomeSetor + " já está cadastrado");
		}else {
			repEvento.get(evento).addSetor(new Setor(nomeSetor, preco, capacidade));
			System.out.println("Setor adicionado com sucesso");
		}
		
	}
	
	
	
	
	
	


	
	

}
