package Agenda;

public class Fone {
	private String label;
	private String numero;
	
	public Fone(String label, String numero) {
		this.label = label;
		this.numero = numero;
	}
	
	
	
	public String getLabel() {
		return label;
	}

	public String getNumero() {
		return numero;
	}

	public static boolean validador(String numero) {
		String caracteresValidos = "()0123456789.-";
		for (int i = 0; i < numero.length(); i++) {
			char caracter = numero.charAt(i);
			if (caracteresValidos.indexOf(caracter) == -1) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return label + ":" + numero;
	}
}
