package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	private String gtin;
	private String quantidade;
	private String nome;

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto [gtin=" + gtin + ", quantidade=" + quantidade + ", nome=" + nome + "]";
	}

}
