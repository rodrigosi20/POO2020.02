package Motoca;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		moto mt1 = new moto();
		int op;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite\n "
					+ "1 - Potência\n"
					+ "2 - Comprar tempo\n"
					+ "3 - Embarcar\n"
					+ "4 - Descer\n"
					+ "5 - Dirigir\n"
					+ "6 - Mostrar carro\n"
					+ "7 - Sair"));
			if (op == 1) {
				int potencia = Integer.parseInt(JOptionPane.showInputDialog("Digite a potencia"));
				mt1 = new moto(potencia);
			}else if (op == 2) {
				int tempo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo que deseja comprar"));
				mt1.comprarTempo(tempo);
			}else if (op == 3) {
				String nome = JOptionPane.showInputDialog("Digite o nome");
				int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
				mt1.subir(new pessoa(nome,idade));
			}else if (op == 4) {
				mt1.descer();
			}else if(op == 5) {
				int tempo = Integer.parseInt(JOptionPane.showInputDialog("Digite quanto tempo você deseja andar"));
				mt1.andar(tempo);
			}else if(op == 6) {
				mt1.mostrar();
			}
			
			
		}while(op != 7);
		
	}
	
	
	

}
