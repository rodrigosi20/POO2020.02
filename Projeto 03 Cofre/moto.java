package Motoca;

import javax.swing.JOptionPane;

public class moto {
	
	public int potencia = 1;
	public int minutos = 0;
	public pessoa passageiro; 
	
	public moto(int potencia) {
		this.potencia = potencia;
	}
	
	public moto() {
		
	}
	
	public void comprarTempo(int quantidade) {
		this.minutos += quantidade;
	}
	
	public void subir(pessoa pessoa) {
		if (this.passageiro == null) {
			this.passageiro = pessoa;
		}else if(this.passageiro != null) {
			JOptionPane.showMessageDialog(null, "Moto ocupada","Fail",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void descer() {
		if (passageiro != null) {
			this.passageiro = null;
		}else {
			JOptionPane.showMessageDialog(null, "Não tem passageiro","Fail",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void andar(int tempo) {
		
		if (passageiro == null) {
			JOptionPane.showMessageDialog(null, "Não tem passageiro","Fail",JOptionPane.ERROR_MESSAGE);
		}else if (passageiro.idade > 10) {
			JOptionPane.showMessageDialog(null, "Você não tem idade para andar","Fail",JOptionPane.ERROR_MESSAGE);
		}else if(minutos == 0) {
			JOptionPane.showMessageDialog(null, "Você não tem minutos","Fail",JOptionPane.ERROR_MESSAGE);
		}else {
			
			if ((minutos - tempo) < 0) {
				JOptionPane.showMessageDialog(null, "Andou " + minutos + " e ficou sem tempo","Fail",JOptionPane.ERROR_MESSAGE);
				minutos = 0;
			}else {
				minutos -= tempo;
			}
		}
		
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Potência: " + potencia + "\n"
				+ "Minutos: " + minutos + "\n"
				+ "Passageiro:" + passageiro, "MOTOCA",JOptionPane.INFORMATION_MESSAGE);
	}

}
