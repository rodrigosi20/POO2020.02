package Carro;

import javax.swing.JOptionPane;

public class Carro {
	public int gasolina = 0;
	public int gasolinaMax = 100;
	public int passageiros = 0;
	public int passageirosmax = 2;
	public int km = 0;
	
	
	
	
	public boolean embarcar() {
		if(passageiros < 2) {
			passageiros += 1;
			return true;
		}else if(passageiros == passageirosmax) {
			JOptionPane.showMessageDialog(null, "Limite de pessoas atingido","Falha",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public boolean desembarcar() {
		if (passageiros > 0) {
			passageiros -= 1;
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Não tem ninguém no carro","Falha",JOptionPane.ERROR_MESSAGE);
		}
		return false;
		
	}
	
	public void abastecer(int qtd_gasolina) {
		if (gasolina < gasolinaMax) {
			gasolina += qtd_gasolina;
			if (gasolina >= gasolinaMax) {
				gasolina = gasolinaMax;
			}
		}
	}
	
	public boolean andar(int distancia) {
		if (passageiros > 0 && gasolina > 0) {
			if((gasolina - distancia) < 0) {
				km += gasolina;
				JOptionPane.showMessageDialog(null, "O tanque ficou vazio depois de andar " + gasolina + "kms","Informação",JOptionPane.INFORMATION_MESSAGE);
				gasolina = 0;
				return true;
			}else {
				gasolina -= distancia;
				km += distancia;
				return true;
			}
		}else if(passageiros == 0) {
			JOptionPane.showMessageDialog(null, "Não tem ninguém no carro","Falha",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			JOptionPane.showMessageDialog(null, "Tanque vazio","Falha",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	
	public String toString() {
		return "Passageiros: " + passageiros + ", Gasolina: " + gasolina + ", Km: " + km;
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Passageiros: " + passageiros + ", Gasolina: " + gasolina + ", Km: " + km, "Carro",JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
