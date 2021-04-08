package Bilheteria;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) throws NumberFormatException {
		Bilheteria b1 = new Bilheteria();
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				String comando = sc.nextLine();
				String[] ui = comando.split(" ");
				if(ui[0].equals("addPessoa")) {
					if (ui[2].equals("meia")) {
						b1.addPessoa(new Pessoa(ui[1], ui[2].equals("meia")));
					}else if (ui[2].equals("inteira")) {
						b1.addPessoa(new Pessoa(ui[1], ui[2].equals("inteira")));
					} else {
						System.out.println("Tipo de ingresso inválido");
					}
					
				}else if (ui[0].equals("addEvento")) {
					b1.addEvento(ui[1]);
				}else if (ui[0].equals("addSetor")) {
					b1.addSetor(ui[1], ui[2], Double.parseDouble(ui[3]), Integer.parseInt(ui[4]));
				}else if (ui[0].equals("vender")) {
					b1.vender(ui[1], ui[2], ui[3]);
				}else if (ui[0].equals("showPessoa")) {
					System.out.println(b1.showPessoas());
				}else if (ui[0].equals("showEvento")) {
					System.out.println(b1.showEventos());
				}else if (ui[0].equals("showVendas")) {
					System.out.println(b1.showVendas());
				}else if (ui[0].equals("showCaixa")) {
					System.out.println(b1.getCaixa());
				}else if (ui[0].equals("end")) {
					System.out.println("Caixa encerrado");
				}else {
					System.out.println("Comando inválido");
				}
			}catch (IndexOutOfBoundsException e) {
				System.out.println(e);
			}catch (NumberFormatException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}

}
