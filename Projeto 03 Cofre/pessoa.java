package Motoca;

public class pessoa {
	public String nome;
	public int idade;
	
	public pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String toString() {
		return "[" + nome + ":" + idade + "]" ;
	}
	

}
