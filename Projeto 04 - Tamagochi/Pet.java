package Tamagochi;

import javax.swing.JOptionPane;

public class Pet {
	
	private int energiaMax;
	private int saciedadeMax;
	private int higieneMax;
	private int energia;
	private int saciedade;
	private int higiene;
	private int diamante;
	private int idade;
	private boolean vida;
	
	public Pet(int energiaMax, int saciedadeMax, int higieneMax) {
		this.energiaMax = energiaMax;
		this.saciedadeMax = saciedadeMax;
		this.higieneMax = higieneMax;
		this.energia = energiaMax;
		this.saciedade = saciedadeMax;
		this.higiene = higieneMax;
		this.diamante = 0;
		this.idade = 0;
		vida = true;
	}
	
	
	
	public boolean getVida() {
		return vida;
	}

	public void play() {
		this.energia -= 2;
		this.saciedade -= 1;
		this.higiene -= 3;
		this.diamante += 1;
		this.idade += 1;
			
	}
	
	public void comer() {
		this.energia -= 1;
		this.saciedade += 4;
		if (saciedade > saciedadeMax) {
			saciedade = saciedadeMax;
		}
		this.higiene -= 2;
		this.idade += 1;
		
	}
	
	public void dormir() {
		if ((energiaMax - energia) >= 5) {
			this.idade += energiaMax - energia;
			this.energia = energiaMax;
			this.saciedade -= 1;
		}else {
			JOptionPane.showMessageDialog(null, "O pet não está com sono","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	public void banhar() {
		this.energia -= 3;
		this.saciedade -= 1;
		this.higiene = higieneMax;
		this.idade += 2;

	}
	
	public void mostrarVida() {
		if (energia <= 0) {
			vida = false;
			energia = 0;
			JOptionPane.showMessageDialog(null, "O pet morreu de fraqueza","O pet está morto",JOptionPane.ERROR_MESSAGE);
		}else if (saciedade <= 0) {
			vida = false;
			saciedade = 0;
			JOptionPane.showMessageDialog(null, "O pet morreu de fome","O pet está morto",JOptionPane.ERROR_MESSAGE);
		}else if(higiene <= 0) {
			higiene = 0;
			vida = false;
			JOptionPane.showMessageDialog(null, "O pet morreu de sujeira","O pet está morto",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Energia: " + energia + "/" + energiaMax + "\n"
				+ "Saciedade: " + saciedade + "/" + saciedadeMax + "\n" 
				+ "Higiene: " + higiene + "/" + higieneMax + "\n"
				+ "Diamantes: " + diamante + "\n"
				+ "Idade: " + idade);
	}
	
	

}
