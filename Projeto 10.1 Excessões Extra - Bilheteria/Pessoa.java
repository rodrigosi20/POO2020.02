package Bilheteria;

public class Pessoa {
	private String nomePessoa;
	private boolean meia;

	public Pessoa(String nome, boolean meia) {
		this.nomePessoa = nome;	
		this.meia = meia;
	}
	
	public boolean getMeia() {
		return meia;
	}
	
	
	


	public String getNomePessoa() {
		return nomePessoa;
	}

	public String toString() {
		String tipoEntrada;
		if (meia) {
			tipoEntrada = "meia";
		}else {
			tipoEntrada = "inteira";
		}
		return "[" + nomePessoa + ", " + tipoEntrada + "]";
	}
	
	
	
	
	

}
