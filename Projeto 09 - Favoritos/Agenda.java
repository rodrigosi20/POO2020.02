package Favoritos;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	
	private TreeMap<String, Contato> contatos;
	private TreeMap<String, Contato> favoritos;
	
	public Agenda() {
		this.contatos = new TreeMap<>();
		this.favoritos = new TreeMap<>();
	}
	
	
	
	public TreeMap<String, Contato> getContatos() {
		return contatos;
	}



	public TreeMap<String, Contato> getFavoritos() {
		return favoritos;
	}



	public void addContato(String nome, ArrayList<Fone> fone) {
		ArrayList<Fone> fones = new ArrayList<>(fone);
		if (!contatos.containsKey(nome)) {
			Contato c = new Contato(nome);
			for (Fone numeros : fones) {
				c.addFone(numeros.getLabel(), numeros.getNumero());
			}
			contatos.put(nome, c);
			System.out.println("Contato adicionado");
			return;
		}
		
		
		for (Fone numeros : fones) {
			contatos.get(nome).addFone(numeros.getLabel(), numeros.getNumero());
		}
			
	}
	
	public boolean rmvContato(String nome) {
		if (!contatos.containsKey(nome)) {
			System.out.println("Contato não encontrado");
			return false;
		}else {
			contatos.remove(nome);
			favoritos.remove(nome);
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
	
	public void favoritar(String id) {
		if (contatos.containsKey(id)) {
			Contato c = this.contatos.get(id);
			contatos.get(id).setStarred(true);
			favoritos.put(id, c);
			System.out.println("O contato foi adicionado aos favoritos");
			return;
		}
		
		System.out.println("Contato não encontrado");
	}
	
	public void remfav(String id) {
		if (contatos.containsKey(id)) {
			contatos.get(id).setStarred(false);
			favoritos.remove(id);
			System.out.println("Contato removido dos favoritos");
		}
	}
	
	public String toString() {
		String painel = "";
		for (Contato contatos : contatos.values()) {
			painel += contatos + "\n";
		}
		
		return painel;
	}
	
	

}
