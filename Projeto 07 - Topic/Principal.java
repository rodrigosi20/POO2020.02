package Topic;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Topic t1 = new Topic(0,0);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os comandos");
		
		while (true) {
			String line = sc.nextLine();
			String [] comandos = line.split(" ");
			if (comandos[0].equals("init")) {
				t1 = new Topic(Integer.parseInt(comandos[1]),Integer.parseInt(comandos[2]));
			}else if (comandos[0].equals("show")) {
					System.out.println(t1);
			}else if (comandos[0].equals("in")) {
				if (comandos.length <= 2) {
					System.out.println("Comando inválido");
				}else {
					t1.embarcar(new Passageiro(comandos[1],Integer.parseInt(comandos[2])));
				}
				
			}else if(comandos[0].equals("out")) {
				t1.desembarcar(comandos[1]);
			}else if(comandos[0].equals("end")) {
				System.out.println("Programa finalizado");
				break;
			}else {
				System.out.println("Comando inválido");
			}
		}
	}

}
