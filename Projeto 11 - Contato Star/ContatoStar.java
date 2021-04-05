package Contato;

import java.util.ArrayList;

public class ContatoStar extends Contato {
	private boolean star;
	
	public ContatoStar(String nome) {
		super(nome);
		this.star = false;
	}
	public ContatoStar(String nome, ArrayList<Fone> fones) {
		super(nome, fones);
		this.star = false;
	}
	
	public void setStar(boolean star) {
		this.star = star;
	}

	public String toString() {
		String painel = "";
		if (star == true) {
			painel += "@ " + getNome();
		}else {
			painel += "- " + getNome();
		}
		
		for (int i = 0; i < getFones().size(); i++) {
			painel += "[" + getFones().get(i).getId() + ":" + getFones().get(i).getNumero() + "]";
		}
		
		return painel;
	}

}
