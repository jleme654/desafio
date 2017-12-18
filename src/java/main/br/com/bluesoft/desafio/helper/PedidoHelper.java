package br.com.bluesoft.desafio.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bluesoft.desafio.api.FornecedorController;
import br.com.bluesoft.desafio.api.ProdutoController;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Precos;
import br.com.bluesoft.desafio.model.Produto;

public class PedidoHelper {

	@Autowired
	FornecedorController fornecedorController;

	@Autowired
	ProdutoController produtoController;

	//private boolean elegivel;

	private List<Pedido> listaPedido = new ArrayList<Pedido>();
	

	public List<Pedido> calculaListaPedido(Produto[] produtos) {
		List<Produto> listaProdutos = Arrays.asList(produtos);
		try {
			for (int i = 0; i < produtos.length; i++) {
				Produto produto = produtos[i];
				String gtin = produto.getGtin();
				String quantidade_web = produto.getQuantidade();

				Pedido pedido = calculaPedido(gtin, quantidade_web, listaProdutos);
				if(null != pedido)
					listaPedido.add(pedido);
			}
			
			//ordena a lista de pedidos 
			
		} catch (InstantiationException | IllegalAccessException | IOException | ParseException e) {
			e.printStackTrace();
		}
		return listaPedido;
	}

	// parametros oriundos da web
	public Pedido calculaPedido(String gtin, String quantidade_web, List<Produto> listaProdutos )
			throws InstantiationException, IllegalAccessException, IOException, ParseException {

		Pedido pedido = new Pedido();

		fornecedorController = new FornecedorController();
		List<Fornecedor> listaFornecedores = fornecedorController.findAllFornecedoresByGtin(gtin);

		for (Fornecedor fornecedor : listaFornecedores) {
			fornecedor = getFornecedorMelhorPreco(fornecedor, quantidade_web);

			// nestas condicoes a app somente adicionara ao pedido a lista de produtos que
			// obedecem a codicao da quantidade minima	
			pedido.setProdutos(listaProdutos);
			pedido.setFornecedor(fornecedor);
		}
		return pedido;
	}
	
	public Fornecedor getFornecedorMelhorPreco(Fornecedor f, String quantidade_web) {
		List<Precos> listaPrecos = f.getPrecos();//Arrays.asList(f.getPrecos());
		List<Precos> novaListaPrecos = new ArrayList<Precos>();
		
		// item preco
	    String menor_preco_str = listaPrecos.get(0).getPreco();
	    double menor_preco_double = Double.valueOf(menor_preco_str);
	    
	    for (int i = 0; i < listaPrecos.size(); i++) {
			// item preco
	    	String preco = listaPrecos.get(i).getPreco();
			double preco_double = Double.valueOf(preco);
			
			// item quantidade
			String qtde_minima_str = listaPrecos.get(i).getQuantidade_minima();
			int qtde_min = Integer.parseInt(qtde_minima_str);
			int qtde_min_web = Integer.parseInt(quantidade_web);			
			
			// condicoes de quantidade e preco juntas
			if (preco_double <= menor_preco_double && qtde_min_web > qtde_min) {
				novaListaPrecos.add(i, listaPrecos.get(i));
			}
		}
		f.setPrecos(novaListaPrecos);
	    
		return f;
	}
	
	// app verifica se quantidade solicitada pela web suporta a quantidade minima
	// exigida de venda do produto
	/*public boolean getElegivelParaCompra(int count, Fornecedor fornecedor, Produto produto) {
		elegivel = true;

		// item quantidade
		List<Precos> precos = fornecedor.getPrecos();//Arrays.asList(fornecedor.getPrecos());
		String qtde_minima_str = precos.get(count).getQuantidade_minima();
		int qtde_minima = Integer.parseInt(qtde_minima_str);

		String qtde_web_str = produto.getQuantidade();
		int qtde_web = Integer.parseInt(qtde_web_str);
		
		if (qtde_web >= qtde_minima)
			return elegivel;
		else
			return !elegivel;
	}
*/
}
