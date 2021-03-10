package Tarifas;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Conta c1 = new Conta(0);
		System.out.println("Menu\n" + "init - Iniciar conta\n"
				+ "show - Mostrar conta\n"
				+ "deposito - Depositar\n"
				+ "saque - Sacar\n"
				+ "tarifa - Pagar Tarifas\n"
				+ "extorno - Extornar Tarifa\n"
				+ "Extrato - Mostrar histórico");
	
		
		while (true) {
			
			String line = sc.nextLine();
			String[] ui = line.split(" ");
			
			if (ui[0].equals("init")) {
				c1 = new Conta(Integer.parseInt(ui[1]));
			}else if (ui[0].equals("show")) {
				System.out.println(c1);
			}else if (ui[0].equals("deposito")) {
				c1.depositar(Double.parseDouble(ui[1]));
			}else if (ui[0].equals("saque")) {
				c1.debitar("saque", Double.parseDouble(ui[1]));
			}else if (ui[0].equals("tarifa")) {
				c1.debitar("tarifa", Double.parseDouble(ui[1]));
			}else if (ui[0].equals("extorno")) {
				c1.extornar(line);
			}else if (ui[0].equals("extrato")) {
				c1.getExtratos();
			}else if (ui[0].equals("extratoN")) {
				c1.getExtratosN(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("end")) {
				System.out.println("Programa finalizado");
				break;
			}else {
				System.out.println("Comando inválido");
			}
			
		}
	}

}
