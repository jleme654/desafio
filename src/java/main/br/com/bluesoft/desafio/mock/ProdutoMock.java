package br.com.bluesoft.desafio.mock;

import br.com.bluesoft.desafio.model.Produto;

public class ProdutoMock {
	
	public static Produto getProdutoMock() {
		Produto p = new Produto();
		p.setGtin("7894900011517");
		p.setNome("REFRIGERANTE COCA-COLA 2LT");
		p.setQuantidade("10");
		return p;
	}
	
	public static Produto getProdutoMock2() {
		Produto p = new Produto();
		p.setGtin("7891910000197");
		p.setNome("AÇÚCAR REFINADO UNIÃO 1KG");
		p.setQuantidade("20");
		return p;
	}
	
	public static Produto getProdutoMock3() {
		Produto p = new Produto();
		p.setGtin("7892840222949");
		p.setNome("SALGADINHO FANDANGOS QUEIJO");
		p.setQuantidade("5");
		return p;
	}
	
	public static Produto getProdutoMock4() {
		Produto p = new Produto();
		p.setGtin("7891910007110");
		p.setNome("AÇÚCAR DE CONFEITEIRO UNIÃO GLAÇÚCAR");
		p.setQuantidade("5");
		return p;
	}
	
	public static Produto getProdutoMock5() {
		Produto p = new Produto();
		p.setGtin("7891000053508");
		p.setNome("ACHOCOLATADO NESCAU 2.0");
		p.setQuantidade("5");
		return p;
	}
	
	public static Produto getProdutoMock6() {
		Produto p = new Produto();
		p.setGtin("7891000100103");
		p.setNome("LEITE CONDENSADO MOÇA");
		p.setQuantidade("5");
		return p;
	}
	
	public static Produto getProdutoMock7() {
		Produto p = new Produto();
		p.setGtin("7891991010856");
		p.setNome("CERVEJA BUDWEISER");
		p.setQuantidade("50");
		return p;
	}
	
	public static Produto[] getProdutoArrayMock() {
		Produto[] arr = new Produto[] {getProdutoMock(), getProdutoMock2(),
				getProdutoMock3(), getProdutoMock4(), getProdutoMock5(),
				getProdutoMock6(), getProdutoMock7()};
		return arr;
	}

}
