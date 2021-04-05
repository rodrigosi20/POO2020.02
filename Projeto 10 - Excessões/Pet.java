package Pet;

public class Pet {
	int energia;
	int energiaMax;
	int saciedade;
	int saciedadeMax;
	int limpeza;
	int limpezaMax;
	int diamantes;
	int idade;
	boolean estarVivo;
	
	public Pet(int energia, int saciedade, int limpeza) {
		this.energiaMax = energia;
		this.energia = energiaMax;
		this.saciedadeMax = saciedade;
		this.saciedade = saciedadeMax;
		this.limpezaMax = limpeza;
		this.limpeza = limpezaMax;
		this.diamantes = 0;
		this.idade = 0;
		this.estarVivo = true;
		
	}
	
	public void verificarVida() {
		if (this.energia <= 0) {
			System.out.println("O Pet morreu de cansaço");
			estarVivo = false;
		}else if (this.saciedade <= 0) {
			System.out.println("O Pet morreu de fome");
			estarVivo = false;
		}else if (this.limpeza <= 0) {
			System.out.println("O Pet morreu de sujeira");
			estarVivo = false;
		}else {
			estarVivo = true;
		}
		
	}
	
	public void atualizarSaciedade() {

		if (saciedade > saciedadeMax) {
			saciedade = saciedadeMax;
		}
	}
	
	public void Play() {
		if (!estarVivo) {
			throw new RuntimeException("O Pet estar morto");
		}else {
			if (energia < 2) {
				throw new RuntimeException("O Pet está cansado");
			}else {
				this.energia -= 2;
				this.saciedade -= 1;
				this.limpeza -= 3;
				this.diamantes += 1;
				this.idade += 1;
				verificarVida();
			}
		}
	}
	
	public void Comer() {
		if (!estarVivo) {
			throw new RuntimeException("O Pet estar morto");
		}else {
			if (saciedade == saciedadeMax) {
				throw new RuntimeException("O Pet não está com fome");
			}else {
				this.energia -= 1;
				this.saciedade += 4;
				atualizarSaciedade();
				this.limpeza -= 2;
				this.diamantes += 0;
				this.idade += 1;
				verificarVida();
			}
		}
	}
	
	public void Dormir() {
		if (!estarVivo) {
			throw new RuntimeException("O Pet estar morto");
		}else {
			if ((energiaMax - energia) < 5) {
				throw new RuntimeException("O Pet não está com sono");
			}else {
				this.energia = this.energiaMax;
				this.idade += energiaMax - energia;
				verificarVida();
			}
		}
	}
	
	public void Banhar() {
		if (!estarVivo) {
			throw new RuntimeException("O Pet estar morto");
		}else {
			if (limpeza == limpezaMax) {
				throw new RuntimeException("O Pet não está sujo");
			}else {
				this.energia -= 3;
				this.saciedade -= 1;
				this.limpeza = limpezaMax;
				this.idade += 2;
				verificarVida();
			}
		}
	}

	@Override
	public String toString() {
		return "Pet [E:" + energia + "/" + energiaMax + ", S:" + saciedade + "/"
				+ saciedadeMax + ", L:" + limpeza + "/" + limpezaMax + ", D:" + diamantes
				+ ", I:" + idade + "]";
	}
	
	
	
	
	
	
}
