package Contato;

import java.util.ArrayList;

public class Contato implements Comparable<Contato> {

	private String nome;
	private ArrayList<Fone> fones;

	public Contato(String nome) {
		this.nome = nome;
		this.fones = new ArrayList<>();
	}
	
	public Contato(String nome, ArrayList<Fone> fones) {
		this.nome = nome;
		this.fones = fones;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Fone> getFones() {
		return fones;
	}


	public void addFone(String label, String numero) {
		if (Fone.Validate(numero)) {
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
	
	public int compareTo(Contato o) {
		return nome.compareTo(o.nome);
	}
	
	public String toString() {
		String painel = "";
		painel += nome;
		for (int i = 0; i < fones.size(); i++) {
			painel += "[" + fones.get(i).getId() + ":" + fones.get(i).getNumero() + "]";
		}
		return painel;
	}
	
}
