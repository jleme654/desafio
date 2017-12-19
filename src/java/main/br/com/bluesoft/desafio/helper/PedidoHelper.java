package br.com.bluesoft.desafio.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bluesoft.desafio.api.FornecedorController;
import br.com.bluesoft.desafio.api.ProdutoController;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Precos;
import br.com.bluesoft.desafio.model.Produto;

public class PedidoHelper {

	@Autowired
	FornecedorController fornecedorController;

	@Autowired
	ProdutoController produtoController;

	private List<Pedido> listaPedido = new ArrayList<Pedido>();
	

	public List<Pedido> calculaListaPedido(Produto[] produtos) {
		try {
			for (int i = 0; i < produtos.length; i++) {
				Produto produto = produtos[i];
				String gtin = produto.getGtin();
				String quantidade_web = produto.getQuantidade();

				Pedido pedido = calculaPedido(gtin, quantidade_web, produto);
				if(null != pedido)
					listaPedido.add(pedido);
			}
			
		} catch (InstantiationException | IllegalAccessException | IOException | ParseException e) {
			e.printStackTrace();
		}
		
		// ordenando a lista de pedidos
	    Collections.sort (listaPedido, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                Pedido p1 = (Pedido) o1;
                Pedido p2 = (Pedido) o2;
                return p1.getId() < p2.getId() ? +1 : (p1.getId() > p2.getId() ? -1 : 0);
            }
        });
		return listaPedido;
	}

	// parametros oriundos da web
	public Pedido calculaPedido(String gtin, String quantidade_web, Produto produto )
			throws InstantiationException, IllegalAccessException, IOException, ParseException {

		Pedido pedido = new Pedido();

		fornecedorController = new FornecedorController();
		List<Fornecedor> listaFornecedores = fornecedorController.findAllFornecedoresByGtin(gtin);

		int count = 0;
		for (Fornecedor fornecedor : listaFornecedores) {
			List<Item> itens = new ArrayList<>();
			
			int qtde_web_int = Integer.parseInt(quantidade_web);

			for(Precos precoitem : fornecedor.getPrecos()) {
				String preco = precoitem.getPreco();
				String quantidade_min = precoitem.getQuantidade_minima();
				int qtde_min_fornecedor = Integer.parseInt(quantidade_min);
				
				// condicao da quantidade minima
				if(qtde_web_int >= qtde_min_fornecedor) {
					Item item = new Item();
					item.setPreco(Double.valueOf(preco));
					item.setProduto(produto);
					item.setQuantidade(qtde_web_int);
					Double total = qtde_web_int*Double.valueOf(preco);
					item.setTotal(total);
				
					itens.add(item);
				}
				
				pedido.setId(++count);
				pedido.setItens(itens);
				pedido.setFornecedor(fornecedor);
			}
			
		}
		return pedido;
	}
	
	private List<Item> getItensMelhorPreco(List<Item> itens) {
		List<Item> itensMelhorPreco = new ArrayList<>();
		
		// condicao de melhor preco - ordenando a lista de itens por melhor preco
	    Collections.sort (itens, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
            	Item p1 = (Item) o1;
            	Item p2 = (Item) o2;
                return p1.getPreco() > p2.getPreco() ? +1 : p1.getPreco() < p2.getPreco() ? -1 : 0;
            }
        });
		//o primeiro item com o melhor preco vai a nova lista de itens
	    itensMelhorPreco.add(itens.get(0));
		
	    return itensMelhorPreco;
	}
	
	/*public Fornecedor getFornecedorMelhorPreco(Fornecedor f, String quantidade_web) {
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
			if (preco_double <= menor_preco_double && qtde_min_web >= qtde_min) {
				novaListaPrecos.add(i, listaPrecos.get(i));
			}
		}
	    // ordenando a lista em ordem crescente de preco
	    Collections.sort (novaListaPrecos, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                Precos p1 = (Precos) o1;
                Precos p2 = (Precos) o2;
                return Double.valueOf(p1.getPreco()) > Double.valueOf(p2.getPreco()) ? +1 : (Double.valueOf(p1.getPreco()) < Double.valueOf(p2.getPreco()) ? -1 : 0);
            }
        });
	    
		f.setPrecos(novaListaPrecos);
	    
		return f;
	}*/
	
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
