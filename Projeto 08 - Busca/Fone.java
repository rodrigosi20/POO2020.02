package Agenda;

public class Fone {
	public String label;
	public String numero;
	
	public Fone(String serial) {
		String[] num = serial.split(":");
		this.label = num[0];
		this.numero = num[1];
	}
	
	public Fone(String label, String numero) {
		this.label = label;
		this.numero = numero;
	}
	
	public static boolean validate(String numero) {
		String validos = "0123456789().-";
		for (int i = 0; i < numero.length(); i++) {
			char car = numero.charAt(i);
			if (validos.indexOf(car) == -1) {
				return false;
			} 
		}
		
		return true;
	}
	
	public String toString() {
		return this.label + ":" + this.numero;
	}
	
	

}
