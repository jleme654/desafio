package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
@Entity
public class Fornecedor {

	/**
	 * variaveis
	 */
	@Id
	private String cnpj;
	private String[] precos;
	private String nome;

	/**
	 * encapsulamentos
	 */
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String[] getPrecos() {
		return precos;
	}

	public void setPrecos(String[] precos) {
		this.precos = precos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
