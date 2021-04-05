package Pet;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pet pet = null;
		while (true) {
			try {
				String comando = sc.nextLine();
				String[] ui = comando.split(" ");
				if (ui[0].equals("init")) {
					pet = new Pet(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));
				}else if (ui[0].equals("play")) {
					pet.Play();
				}else if (ui[0].equals("eat")) {
					pet.Comer();
				}else if (ui[0].equals("sleep")) {
					pet.Dormir();
				}else if (ui[0].equals("clean")) {
					pet.Banhar();
				}else if(ui[0].equals("show")) {
					System.out.println(pet);
				}else if (ui[0].equals("sair")) {
					break;
				}else {
					System.out.println("Comando inválido");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Falha, valor inválido");
			} catch (java.lang.RuntimeException e) {
				System.out.println(e);
			}
			
		}
	}

}
