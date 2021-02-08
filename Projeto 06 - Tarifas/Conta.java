package Tarifas;

import java.util.ArrayList;

public class Conta {
	public double saldo;
	public int numero;
	public ArrayList<Opera��o> extrato;
	public ArrayList<Integer> extornados = new ArrayList<>();
	
	public Conta(int numero) {
		this.numero = numero;
		this.extrato = new ArrayList<>();
		extrato.add(new Opera��o("Abertura", 0.0,0.0));
	}
	
	public void addOpera��o(String desc, double valor) {
		extrato.add(new Opera��o(desc,valor,this.saldo));
	}
	
	public void depositar(double valor) {
		if (valor < 0) {
			System.out.println("Valor inv�lido");
		}else {
			saldo += valor;
			addOpera��o("deposito", valor);
		}
	}
	
	public void debitar(String op,double valor) {
		if (valor > saldo && op.equals("saque")) {
			System.out.println("Saldo insuficiente");
		}else if (valor <= saldo && op.equals("saque")) {
			saldo -= valor;
			extrato.add(new Opera��o(op, -valor,this.saldo));
		}else {
			saldo -= valor;
			extrato.add(new Opera��o(op, -valor,this.saldo));
		}
	}
	public boolean validarExtorno(int ind) {
		for (int i = 0; i < extornados.size(); i++) {
			if (extornados.get(i) == ind) {
				return false;
			}
		}
		return true;
	
	}
	
	public void extornar(String comando) {
		String[] line = comando.split(" ");
			for (int i = 1; i < line.length; i++) {
			if (Integer.parseInt(line[i]) <= 0 || Integer.parseInt(line[i]) > extrato.size() || extrato.size() == 1 ) {
				System.out.println("Indice inv�lido " + Integer.parseInt(line[i]) );
			}else {
				if(!validarExtorno(Integer.parseInt(line[i]))){
					System.out.println("Valor j� extornado");
				}else if(extrato.get(Integer.parseInt(line[i])).descricao.equals("tarifa")) {
					this.saldo += (extrato.get(Integer.parseInt(line[i])).valor * (-1));
					extrato.add(new Opera��o("Extorno",extrato.get(Integer.parseInt(line[i])).valor * -1,this.saldo));
					extornados.add(Integer.parseInt(line[i]));
				}else{
					System.out.println("O indice digitado n�o � tarifa " + Integer.parseInt(line[i]));
				}
			}
		}
	}
	
	public ArrayList<Opera��o> getExtratos(){
		String ex = "";
		for (int i = 0; i < extrato.size(); i++) {
			ex += i + " : " + extrato.get(i).descricao + " : " + extrato.get(i).valor + " : " + extrato.get(i).saldo + "\n" ;
		}
		System.out.println(ex);
		return extrato;
		
	}
	
	public ArrayList<Opera��o> getExtratosN(int qtd){
		if (qtd > extrato.size() || qtd <= 0) {
			System.out.println("�ndice inv�lido");
			return extrato;
		}else {
			String ex = "";
			for (int i = extrato.size() - qtd; i < extrato.size(); i++) {
				ex += i + " : " + extrato.get(i).descricao + " : " + extrato.get(i).valor + " : " + extrato.get(i).saldo + "\n" ;
			}
			System.out.println(ex);
			return extrato;
		}
		
		
	}

	public String toString() {
		return "Numero: " + numero + " Saldo: " + saldo;
	}
	
	
	
	
}


















