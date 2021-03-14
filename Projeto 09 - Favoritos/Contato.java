package Favoritos;

import java.util.ArrayList;

public class Contato {
	private String nome;
	private ArrayList<Fone> fones;
	private boolean starred;
	
	public Contato(String nome) {
		this.nome = nome;
		this.fones = new ArrayList<Fone>();
		this.starred = false;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public ArrayList<Fone> getFones() {
		return fones;
	}



	public void setStarred(boolean starred) {
		this.starred = starred;
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
	
	public String toString() {
		String painel = "";
		if (starred == true) {
			painel += "@ " + this.nome + fones;
		}else {
			painel += "- " + this.nome + fones;
		}
		
		return painel;
	}
	

}








