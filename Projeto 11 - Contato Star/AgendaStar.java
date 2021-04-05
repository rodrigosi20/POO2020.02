package Contato;

import java.util.Map;
import java.util.TreeMap;

public class AgendaStar extends Agenda {
	private TreeMap<String, ContatoStar> favs;
	
	public AgendaStar() {
		super();
		favs = new TreeMap<>();
	}
	
	public Map<String, ContatoStar> getFavs(){
		return favs;
	}
	
	public void starContato(String id) {
		if (getContatos().containsKey(id)) {
			ContatoStar cs = new ContatoStar(id, this.getContatos().get(id).getFones());
			favs.put(id, cs);
			favs.get(id).setStar(true);
			System.out.println("Contato adicionado aos favoritos");
			return;
			
		}
		
		System.out.println("Contato não encontrado");
	}
	
	public void unnstar(String id) {
		if (getContatos().containsKey(id)) {
			favs.get(id).setStar(false);
			favs.remove(id);
			System.out.println("O contato foi removido dos favoritos");
			return;
		}
		
		System.out.println("Contato não encontrado");
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
