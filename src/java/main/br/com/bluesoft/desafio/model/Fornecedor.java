package br.com.bluesoft.desafio.model;

import java.util.List;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
// @Entity
public class Fornecedor {

	/**
	 * variaveis
	 */
	// @Id
	private String cnpj;
	private List<Precos> precos;
	private String nome;

	/**
	 * encapsulamentos
	 */
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj.replace("\\", "");
	}

	public List<Precos> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Precos> precos) {
		this.precos = precos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", precos=" + precos + ", nome=" + nome + "]";
	}

}
