package Agenda;

import java.util.ArrayList;

public class Contato implements Comparable<Contato> {
	public String nome;
	public ArrayList<Fone> fones;
	
	public Contato(String nome) {
		this.nome = nome;
		this.fones = new ArrayList<>();
	}
	
	public void addFone(String label, String numero) {
		if (Fone.validate(numero)) {
			fones.add(new Fone(label, numero));
		}else {
			System.out.println("Número inválido");
		}
	}
	
	public void rmFone(int index) {
		for (int i = 0; i < fones.size(); i++) {
			if (index == i) {
				fones.remove(index);
				break;
			}
		}
		
		System.out.println("Index não encontrado");
	}
	
	public String toString() {
		String painel = this.nome;
		return painel += fones;
	}

	
	public int compareTo(Contato o) {
		return nome.compareTo(o.nome);
	}

}
