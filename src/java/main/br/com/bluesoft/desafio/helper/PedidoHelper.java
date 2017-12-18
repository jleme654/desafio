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

	private boolean elegivel;

	private List<Pedido> listaPedido = new ArrayList<>();

	public List<Pedido> calculaListaPedido(Produto[] produtos) {
		List<Produto> listaProdutos = Arrays.asList(produtos);
		try {
			for (int i = 0; i < produtos.length; i++) {
				Produto produto = produtos[i];
				String gtin = produto.getGtin();

				Pedido pedido = calculaPedido(gtin, listaProdutos);
				if(null != pedido)
					listaPedido.add(pedido);
			}
		} catch (InstantiationException | IllegalAccessException | IOException | ParseException e) {
			e.printStackTrace();
		}
		return listaPedido;
	}

	// parametros oriundos da web
	public Pedido calculaPedido(String gtin, List<Produto> produtos)
			throws InstantiationException, IllegalAccessException, IOException, ParseException {

		Pedido pedido = new Pedido();

		List<Fornecedor> listaFornecedores = this.fornecedorController.findAllFornecedoresByGtin(gtin);

		int count = 0;
		for (Fornecedor fornecedor : listaFornecedores) {

			List<Produto> listaProdutosElegiveis = new ArrayList<>();
			for (Produto itemProduto : produtos) {
				elegivel = getElegivelParaVenda(count, fornecedor, itemProduto);
				if (elegivel)
					listaProdutosElegiveis.add(itemProduto);
			}
			//itera a lista
			count++;

			// nestas condicoes a app somente adicionara ao pedido a lista de produtos que
			// obedecem a codicao da quantidade minima
			pedido.setProdutos(listaProdutosElegiveis);
			pedido.setFornecedor(fornecedor);
		}

		return pedido;
	}

	// app verifica se quantidade solicitada pela web suporta a quantidade minima
	// exigida de venda do produto
	public boolean getElegivelParaVenda(int count, Fornecedor fornecedor, Produto produto) {
		elegivel = true;

		List<Precos> precos = Arrays.asList(fornecedor.getPrecos());
		String qtde_minima_str = precos.get(count).getQuantidade_minima();
		int qtde_minima = Integer.parseInt(qtde_minima_str);

		String qtde_web_str = produto.getQuantidade();
		int qtde_web = Integer.parseInt(qtde_web_str);

		if (qtde_web > qtde_minima)
			return elegivel;
		else
			return !elegivel;
	}

}
