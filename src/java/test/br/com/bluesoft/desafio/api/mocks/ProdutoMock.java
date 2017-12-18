package br.com.bluesoft.desafio.api.mocks;

import br.com.bluesoft.desafio.model.Produto;

public class ProdutoMock {
	
	public static Produto getProdutoMock() {
		Produto p = new Produto();
		p.setGtin("7894900011517");
		p.setNome("Julio Teste");
		p.setQuantidade("10");
		return p;
	}
	
	public static Produto[] getProdutoArrayMock() {
		Produto[] arr = new Produto[] {getProdutoMock()};
		return arr;
	}

}
