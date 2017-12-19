package br.com.bluesoft.desafio.model;

import java.io.Serializable;

/**
 * 
 * @author julio.leme
 * @since 2017-12-19
 * @version 1.0
 */
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Integer quantidade;
	private Double preco;
	private Double total;

	/**
	 * encapsulamentos
	 */
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Item [produto=" + produto + ", quantidade=" + quantidade + ", preco=" + preco + ", total=" + total
				+ "]";
	}

}
