package Agenda;

import java.util.ArrayList;
import java.util.Collections;

import javax.accessibility.AccessibleTableModelChange;

public class Agenda {
	
	ArrayList<Contato> contatos;
	
	public Agenda() {
		this.contatos = new ArrayList<>();
	}
	
	public int findContato(String nome) {
		for (int i = 0; i < contatos.size(); i++) {
			if (nome.equals(contatos.get(i).nome)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void addContato(String nome, ArrayList<Fone> fone) {
		ArrayList<Fone> fones = new ArrayList<>(fone);
		int aux = findContato(nome);
		if (aux == -1) {
			Contato c = new Contato(nome);
			for (Fone numeros : fones) {
				c.addFone(numeros.label, numeros.numero);
				
			}
			contatos.add(c);
			Collections.sort(contatos);
			System.out.println("Contato adicionado");
			return;
		}
		
		for (int i = 0; i < contatos.size(); i++) {
			if (nome.equals(contatos.get(i).nome)) {
				Contato c = contatos.get(i);
				c.addFone(fones.get(i).label, fones.get(i).numero);
				System.out.println("Contato já existe, foi adicionado um telefone referente ao contato");
				break;
			}
		}
		
	}
	
	public boolean rmContato(String nome) {
		int aux = findContato(nome);
		if (aux == -1) {
			System.out.println("Contato não encontrado");
			return false;
		}else {
			contatos.remove(aux);
			System.out.println("O contato foi removido com sucesso !");
			return true;
		}
	}
	
	public ArrayList<Contato> search(String pattern){
		ArrayList<Contato> procurados = new ArrayList<>();
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).nome.indexOf(pattern) != -1) {
				procurados.add(contatos.get(i));
			}
		}
		
		for (int i = 0; i < contatos.size(); i++) {
			for (int j = 0; j < contatos.get(i).fones.size(); j++) {
				if (contatos.get(i).fones.get(j).label.indexOf(pattern) != -1 || contatos.get(i).fones.get(j).numero.indexOf(pattern) != -1) {
					procurados.add(contatos.get(i));
				}
			}
		}
		
		if (procurados.size() <= 0) {
			System.out.println("Não encontrado");
			return procurados;
		}
		
		return procurados;
		
		
		
	}
	
	public Contato getContato(String nome) {
		int aux = findContato(nome);
		if (aux != -1) {
			 System.out.println(contatos.get(aux));
			 return contatos.get(aux);
		}
		System.out.println("Contato não encontrado");
		return null;
		
		
	}
	
	public String toString() {
		String painel = "";
		for (int i = 0; i < contatos.size(); i++) {
			painel += contatos.get(i) + "\n";
			
		}
		
		return painel;
	}

}
