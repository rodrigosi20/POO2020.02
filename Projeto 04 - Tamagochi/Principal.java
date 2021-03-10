package Tamagochi;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		
		Pet pet1 = null;
		
		int op = 0;
		
		do {		
			op = Integer.parseInt(JOptionPane.showInputDialog("1- Iniciar\n"
					+ "2- Brincar\n"
					+ "3- Comer\n"
					+ "4- Dormir\n"
					+ "5- banho\n"
					+ "6- Mostrar Estado\n"
					+ "7- Sair"));
			
			if (op == 1) {
				int energia = Integer.parseInt(JOptionPane.showInputDialog("Digite a energia máxima"));
				int saciedade = Integer.parseInt(JOptionPane.showInputDialog("Digite a saciedade"));
				int higiene = Integer.parseInt(JOptionPane.showInputDialog("Digite a higiene máxima"));
				pet1 = new Pet(energia,saciedade,higiene);
			}else if (op == 2) {
				if (pet1.getVida() == false) {
					JOptionPane.showMessageDialog(null, "O pet está morto");
				}else {
					pet1.play();
				}
			}else if(op == 3) {
				if (pet1.getVida() == false) {
					JOptionPane.showMessageDialog(null, "O pet está morto");
				}else {
					pet1.comer();
				}
			}else if (op == 4) {
				if (pet1.getVida() == false) {
					JOptionPane.showMessageDialog(null, "O pet está morto");
				}else {
					pet1.dormir();
				}
			}else if (op == 5) {
				if (pet1.getVida() == false) {
					JOptionPane.showMessageDialog(null, "O pet está morto");
				}else {
					pet1.banhar();
				}
			}else if (op == 6) {
				pet1.mostrar();
			}else {
				break;
			}
			
			pet1.mostrarVida();
			
		}while(op != 7);
		
	}

}
