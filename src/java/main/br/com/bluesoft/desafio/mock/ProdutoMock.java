package br.com.bluesoft.desafio.mock;

import br.com.bluesoft.desafio.model.Produto;

public class ProdutoMock {
	
	public static Produto getProdutoMock() {
		Produto p = new Produto();
		p.setGtin("7894900011517");
		p.setNome("teste");
		p.setQuantidade("10");
		return p;
	}
	
	public static Produto getProdutoMock2() {
		Produto p = new Produto();
		p.setGtin("7892840222949");
		p.setNome("teste2");
		p.setQuantidade("20");
		return p;
	}
	
	public static Produto getProdutoMock3() {
		Produto p = new Produto();
		p.setGtin("7891000053508");
		p.setNome("teste3");
		p.setQuantidade("5");
		return p;
	}
	
	public static Produto[] getProdutoArrayMock() {
		Produto[] arr = new Produto[] {getProdutoMock()};
		return arr;
	}

}
