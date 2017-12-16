package br.com.bluesoft.desafio.helper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.api.FornecedorController;
import br.com.bluesoft.desafio.api.ProdutoController;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;

public class PedidoHelper {

	@Autowired
	FornecedorController fornecedorController;
	
	@Autowired
	ProdutoController produtoController;

	// parametros oriundos da web
	public List<Pedido> calculaPedido(String gtin, String quantidade,  Model model,
			HttpServletRequest request) {
		List<Pedido> listaPedido = new ArrayList<>();
		try {
			
			List<Fornecedor> listaFornecedores = this.fornecedorController.findAllFornecedoresByGtin(gtin);

			for (Fornecedor fornecedor : listaFornecedores) {
				Pedido pedido = new Pedido();
				
				List<Produto> produtos = new ArrayList<>();
				Produto produto = this.produtoController.findOne(gtin, model, request);
				
				//TODO regras para enumerar os produtos com quantidades minimas validas e melhores precos
				
				produtos.add(produto);
				
				pedido.setFornecedor(fornecedor);
				pedido.setProdutos(produtos);
				
				listaPedido.add(pedido );
			}
		

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return listaPedido;
	}

}
