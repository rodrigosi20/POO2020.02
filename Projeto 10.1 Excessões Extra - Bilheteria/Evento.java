package Bilheteria;

import java.util.TreeMap;

public class Evento {
	private String nomeEvento;
	private TreeMap<String, Setor> repSetores;
	
	public Evento(String nome) {
		this.nomeEvento = nome;
		repSetores = new TreeMap<>();
	}
	
	public void addSetor(Setor setor) {
		if (repSetores.containsKey(setor.getNome())) {
			throw new RuntimeException("Fail: Setor já existe");
		}else {
			repSetores.put(setor.getNome(), new Setor(setor.getNome(), setor.getPreco(), setor.getCapacidade()));
		}
	}
	
	public String getNome() {
		return nomeEvento;
	}

	public TreeMap<String, Setor> getRepSetores() {
		return repSetores;
	}
	
	public String toString() {
		String painel = nomeEvento;
		for (Setor setor : repSetores.values()) {
			painel += "[" + setor + "]";
		}
		
		return painel;
	}

	

}
