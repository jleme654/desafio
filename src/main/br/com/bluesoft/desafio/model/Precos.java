package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
public class Precos {

	/**
	 * variaveis
	 */
	private double preco;
	private int quantidade_minima;

	/**
	 * encapsulamentos
	 */
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade_minima() {
		return quantidade_minima;
	}

	public void setQuantidade_minima(int quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}

}
