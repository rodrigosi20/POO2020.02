package Contato;

public class Fone {
	private String id;
	private String numero;
	
	public Fone(String id, String numero) {
		this.id = id;
		this.numero = numero;
	}
	
	public Fone(String serial) {
		String [] tel = serial.split(":");
		this.id = tel[0];
		this.numero = tel[1];
	}
	
	
	
	public String getId() {
		return id;
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
		return this.id + ":" + this.numero;
	}

}
