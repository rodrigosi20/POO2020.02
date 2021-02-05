package Agenda;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contato agenda = new Contato("");
		
		while (true) {
			System.out.println("Digite o comando");
			String comando = sc.nextLine();
			String [] ui = comando.split(" ");
			if (ui[0].equals("show")) {
				System.out.println(agenda);
			}else if (ui[0].equals("init")) {
				agenda = new Contato(ui[1]);
			}else if (ui[0].equals("add")) {
				agenda.adicionarTelefone(ui[1], ui[2]);
			}else if (ui[0].equals("rm")) {
				agenda.removerTelefone(Integer.parseInt(ui[1]));
			}else if (ui[0].equals("end")) {
				System.out.println("Programa finalizado");
				break;
			}else {
				System.out.println("Comando inválido");
			}
			
		}
		
		sc.close();
	}
	
}
