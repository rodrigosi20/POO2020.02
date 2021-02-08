package Topic;

import java.util.ArrayList;

public class Topic {
	public ArrayList<Passageiro> cadeiras;
	public int qtdPrefer;
	
	public Topic(int qtdTotal, int qtdPrefer) {
		
		if (qtdPrefer > qtdTotal) {
			System.out.println("Entrada inválida");
		}else {
			this.qtdPrefer = qtdPrefer;
			cadeiras = new ArrayList<Passageiro>();
			for (int i = 0; i < qtdTotal; i++) {
				cadeiras.add(null);
			}
		}
		
	}
	
	public boolean embarcar(Passageiro pessoa) {
		if (pessoa.getIdade() <= 0) {
			System.out.println("Idade inválida");
			return false;
		}
		boolean lotado = true;
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i) == null) {
				lotado = false;
			}
		}
		
		
		
		// Verificar se a pessoa já está
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i) != null && pessoa.getNome().equals(cadeiras.get(i).getNome()) && pessoa.getIdade() == cadeiras.get(i).getIdade()) {
				System.out.println("Já está na Topic");
				return false;
			}
		}
		
		if (lotado == true) {
			System.out.println("lotato");
			return false;
		}
		
		
		
		if (pessoa.getIdade() > 65) {
			for (int i = 0; i < qtdPrefer; i++) {
				if (cadeiras.get(i) == null) {
					cadeiras.set(i, pessoa);
					return true;
				}
			}
			
			for (int i = qtdPrefer; i < cadeiras.size(); i++) {
				if (cadeiras.get(i) == null) {
					cadeiras.set(i, pessoa);
					return true;
				}
			}
		}else {
			for (int i = qtdPrefer; i < cadeiras.size(); i++) {
				if (cadeiras.get(i) == null) {
					cadeiras.set(i, pessoa);
					return true;
				}
			}
			
			for (int i = 0; i < qtdPrefer; i++) {
				if (cadeiras.get(i) == null) {
					cadeiras.set(i, pessoa);
					return true;
				}
				
			}
		}
		return true;
	}
	
	public void desembarcar(String nome) {
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i) != null && cadeiras.get(i).getNome().equals(nome)) {
				cadeiras.set(i,null);
				return;
			}
		}
		
		System.out.println("Passageiro não se encontra");
		
	}

	
	public String toString() {
		String saida = "[ ";
		for (int i = 0; i < qtdPrefer; i++) {
			if (cadeiras.get(i) == null) {
				saida += "@ ";
			}else {
				saida += "@" + cadeiras.get(i).getNome() + ":" + cadeiras.get(i).getIdade() + " " ;
			}
		}
		
		for (int i =qtdPrefer; i < cadeiras.size(); i++) {
			if (cadeiras.get(i) == null) {
				saida += "= ";
			}else {
				saida += "=" + cadeiras.get(i).getNome() + ":" + cadeiras.get(i).getIdade() + " " ;
			}
		}
			
			
		return saida + "]";
	}
	
	

	
	
	

}
