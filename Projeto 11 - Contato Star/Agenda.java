package Contato;

import java.util.ArrayList;
import java.util.TreeMap;

public class Agenda {

	private TreeMap<String, Contato> contatos;
	
	public Agenda() {
		this.contatos = new TreeMap<>();
	}
	

	public void addContato(String nome, ArrayList<Fone> fone) {
		ArrayList<Fone> fones = new ArrayList<>(fone);
		if (!contatos.containsKey(nome)) {
			Contato c = new Contato(nome);
			for (Fone numeros : fones) {
				c.addFone(numeros.getId(), numeros.getNumero());
			}
			contatos.put(nome, c);
			System.out.println("Contato adicionado");
			return;
		}
		
		
		for (Fone numeros : fones) {
			System.out.println("Telefone adicionado com sucesso");
			contatos.get(nome).addFone(numeros.getId(), numeros.getNumero());
		}
			
	}
	
	public boolean rmvContato(String nome) {
		if (!contatos.containsKey(nome)) {
			System.out.println("Contato não encontrado");
			return false;
		}else {
			contatos.remove(nome);
			System.out.println("Contato Removido");
			return true;
		}
	}
	
	public ArrayList<Contato> search(String pattern){
		ArrayList<Contato> procurados = new ArrayList<>();
		for (String key : contatos.keySet()) {
			if (contatos.get(key).getNome().indexOf(pattern) != -1) {
				procurados.add(contatos.get(key));
			}
		}
		
		for (String key : contatos.keySet()) {
			if (contatos.get(key).getFones().indexOf(pattern) != -1) {
				procurados.add(contatos.get(key));
			}
		}
		
		return procurados;
		
	}
	
	

	public TreeMap<String, Contato> getContatos() {
		return contatos;
	}


	public String toString() {
		String painel = "";
		for (Contato contatos : contatos.values()) {
			painel += contatos + "\n";
		}
		
		return painel;
	}

}
