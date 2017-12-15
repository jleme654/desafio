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
	private Precos precos;
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

	public Precos getPrecos() {
		return precos;
	}

	public void setPrecos(Precos precos) {
		this.precos = precos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
