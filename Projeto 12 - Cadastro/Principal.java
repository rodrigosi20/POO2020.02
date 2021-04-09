package Banco;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		AgenciaBancaria banco = new AgenciaBancaria();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String comando = sc.nextLine();
			String[] ui = comando.split(" ");
			try {
				if (ui[0].equals("end")) {
					System.out.println("Programa encerrado");
					break;
				}else if (ui[0].equals("show")) {
					System.out.println(banco);
				}else if (ui[0].equals("addCliente")) {
					banco.addCliente(ui[1]);
				}else if (ui[0].equals("saque")) {
					banco.sacar(Integer.parseInt(ui[1]), Double.parseDouble(ui[2]));
				}else if (ui[0].equals("deposito")) {
					banco.depositar(Integer.parseInt(ui[1]), Double.parseDouble(ui[2]));
				}else if (ui[0].equals("transferir")) {
					banco.transferir(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Double.parseDouble(ui[3]));
				}else if (ui[0].equals("update")) {
					banco.atualizar();
					System.out.println("Contas atualizadas");
				}else {
					System.out.println("Comando inválido");
				}
			} catch (RuntimeException e) {
				System.out.println(e);
			}
					
		}
	}

}
