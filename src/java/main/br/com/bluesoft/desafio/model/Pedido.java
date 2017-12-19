package br.com.bluesoft.desafio.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Fornecedor fornecedor;
	private List<Item> itens;

	/**
	 * encapsulamentos
	 * 
	 * @return
	 */
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id +", fornecedor=" + fornecedor + ", itens=" + itens + "]";
	}

}
