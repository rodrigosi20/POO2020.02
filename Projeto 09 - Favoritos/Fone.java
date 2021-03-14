package Favoritos;

public class Fone {
	private String label;
	private String numero;
	
	public Fone(String label, String numero) {
		this.label = label;
		this.numero = numero;
	}
	
	public Fone(String serial) {
		String [] tel = serial.split(":");
		this.label = tel[0];
		this.numero = tel[1];
	}
	
	
	
	public String getLabel() {
		return label;
	}

	public String getNumero() {
		return numero;
	}

	public static boolean Validate(String numero) {
		String validos = "0123456789().-";
		for (int i = 0; i < numero.length(); i++) {
			char nums = numero.charAt(i);
			if (validos.indexOf(nums) == -1) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public String toString() {
		return this.label + ":" + this.numero;
	}

}
