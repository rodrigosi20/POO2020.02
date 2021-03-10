package Agenda;

import java.util.ArrayList;
import java.util.Scanner;



public class Principal {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String comando = sc.nextLine();
			String [] ui = comando.split(" ");
			if (ui[0].equals("add")) {
				ArrayList<Fone> fones = new ArrayList<>();
				for (int i = 2; i < ui.length; i++) {
					fones.add(new Fone(ui[i]));
				}
				
				agenda.addContato(ui[1], fones);
			}else if (ui[0].equals("rm")) {
				agenda.rmContato(ui[1]);
			}else if (ui[0].equals("show")) {
				System.out.println(agenda);
			}else if (ui[0].equals("search")) {
				for (Contato contato : agenda.search(ui[1])) {
					System.out.println(contato);
				}
			}else if (ui[0].equals("getContato")) {
				agenda.getContato(ui[1]);
			}else if (ui[0].equals("end")) {
				System.out.println("Programa finalizado");
				break;
			}else {
				System.out.println("Comando inválido");
			}
		}
	}

}
