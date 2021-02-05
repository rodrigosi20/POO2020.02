package Agenda;

import java.util.ArrayList;

public class Contato {
	
	public String nome;
	public ArrayList<Fone> telefones;
	
	public Contato(String nome) {
		this.nome = nome;
		this.telefones = new ArrayList<>();
	}
	
	public void adicionarTelefone(String label, String numero) {
		if (Fone.validador(numero)) {
			telefones.add(new Fone(label, numero));
			System.out.println("Telefone adicionado com sucesso");
		}else {
			System.out.println("Número inválido");
		}
		
	}
	
	public void removerTelefone(int indice) {
		if (telefones.size() == 0) {
			System.out.println("Agenda vazia");
		}else {
			for (int i = 0; i < telefones.size(); i++) {
				if (indice == i) {
					telefones.remove(indice);
					System.out.println("O número foi removido com sucesso");
				}else {
					System.out.println("Indice não encontrado");
				}
			}
		}
	}
	
	public String toString() {
		String painel = "-" + this.nome;
		for (int i = 0; i < telefones.size(); i++) {
			painel += " [" + i + ":" + telefones.get(i).getLabel() + ":" + telefones.get(i).getNumero() + "]";
		}
		return painel;
	}
	
}
