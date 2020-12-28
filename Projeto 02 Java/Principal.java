package Carro;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		
		Carro carro1 = new Carro();
		
		int op = 0;
		do {
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite\n"
					+ "1 - Embarcar\n"
					+ "2 - Desembarcar\n"
					+ "3 - Abastecer\n"
					+ "4 - Andar\n"
					+ "5 - Mostrar carro\n"
					+ "6 - Sair"));
			
			if (op == 1) {
				carro1.embarcar();
			}else if(op == 2) {
				carro1.desembarcar();
			}else if (op == 3) {
				int qtd_gasolina = Integer.parseInt(JOptionPane.showInputDialog("Quanto deseja abastecer ?"));
				carro1.abastecer(qtd_gasolina);
			}else if (op == 4) {
				int distancia = Integer.parseInt(JOptionPane.showInputDialog("Quanto deseja andar ?"));
				carro1.andar(distancia);
			}else if (op == 5) {
				carro1.mostrar();
			}else {
				JOptionPane.showMessageDialog(null, "Programa finalizado");
			}
			
		}while(op != 6);
		
	}

}
