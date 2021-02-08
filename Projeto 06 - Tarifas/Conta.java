package Tarifas;

import java.util.ArrayList;

public class Conta {
	public double saldo;
	public int numero;
	public ArrayList<Operação> extrato;
	public ArrayList<Integer> extornados = new ArrayList<>();
	
	public Conta(int numero) {
		this.numero = numero;
		this.extrato = new ArrayList<>();
		extrato.add(new Operação("Abertura", 0.0,0.0));
	}
	
	public void addOperação(String desc, double valor) {
		extrato.add(new Operação(desc,valor,this.saldo));
	}
	
	public void depositar(double valor) {
		if (valor < 0) {
			System.out.println("Valor inválido");
		}else {
			saldo += valor;
			addOperação("deposito", valor);
		}
	}
	
	public void debitar(String op,double valor) {
		if (valor > saldo && op.equals("saque")) {
			System.out.println("Saldo insuficiente");
		}else if (valor <= saldo && op.equals("saque")) {
			saldo -= valor;
			extrato.add(new Operação(op, -valor,this.saldo));
		}else {
			saldo -= valor;
			extrato.add(new Operação(op, -valor,this.saldo));
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
				System.out.println("Indice inválido " + Integer.parseInt(line[i]) );
			}else {
				if(!validarExtorno(Integer.parseInt(line[i]))){
					System.out.println("Valor já extornado");
				}else if(extrato.get(Integer.parseInt(line[i])).descricao.equals("tarifa")) {
					this.saldo += (extrato.get(Integer.parseInt(line[i])).valor * (-1));
					extrato.add(new Operação("Extorno",extrato.get(Integer.parseInt(line[i])).valor * -1,this.saldo));
					extornados.add(Integer.parseInt(line[i]));
				}else{
					System.out.println("O indice digitado não é tarifa " + Integer.parseInt(line[i]));
				}
			}
		}
	}
	
	public ArrayList<Operação> getExtratos(){
		String ex = "";
		for (int i = 0; i < extrato.size(); i++) {
			ex += i + " : " + extrato.get(i).descricao + " : " + extrato.get(i).valor + " : " + extrato.get(i).saldo + "\n" ;
		}
		System.out.println(ex);
		return extrato;
		
	}
	
	public ArrayList<Operação> getExtratosN(int qtd){
		if (qtd > extrato.size() || qtd <= 0) {
			System.out.println("Índice inválido");
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


















