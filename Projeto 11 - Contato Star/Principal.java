package Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		AgendaStar ag = new AgendaStar();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String comando = sc.nextLine();
			String[] ui = comando.split(" ");
			if (ui[0].equals("add")) {
				ArrayList<Fone> fones = new ArrayList<>();
				for (int i = 2; i < ui.length; i++) {
					fones.add(new Fone(ui[i]));
				}
				ag.addContato(ui[1], fones);
			}else if (ui[0].equals("show")) {
				System.out.println(ag);
			}else if (ui[0].equals("star")) {
				ag.starContato(ui[1]);
			}else if (ui[0].equals("starred")) {
				for(String key : ag.getContatos().keySet()) {
					System.out.println(ag.getContatos().get(key));
				}
			}else if (ui[0].equals("unstar")) {
				ag.unnstar(ui[1]);
			}else if (ui[0].equals("end")) {
				System.out.println("Programa finalizado");
				break;
			}else if (ui[0].equals("search")) {
				for (Contato contato : ag.search(ui[1])) {
					System.out.println(contato);
				}
			}else if (ui[0].equals("rm")) {
				ag.rmvContato(ui[1]);
			}
		}
	}

}
