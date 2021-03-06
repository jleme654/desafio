package br.com.bluesoft.desafio.model;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
public class Precos {

	private String preco;
	private String quantidade_minima;

	/**
	 * encapsulamentos
	 */
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade_minima() {
		return quantidade_minima;
	}

	public void setQuantidade_minima(String quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}

	@Override
	public String toString() {
		return "Precos [preco=" + preco + ", quantidade_minima=" + quantidade_minima + "]";
	}
}
