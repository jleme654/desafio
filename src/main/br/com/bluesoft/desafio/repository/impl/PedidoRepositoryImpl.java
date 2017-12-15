package br.com.bluesoft.desafio.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Precos;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.repository.PedidoRepository;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
public class PedidoRepositoryImpl implements PedidoRepository {

	@Override
	public Pedido getPedidoByGtinAndQuantidade(Fornecedor fornecedor, int quantidade) throws JsonProcessingException {
		Precos[] precos = new Precos[2];
		if(quantidade < Integer.parseInt(precos[1].toString()))
			return new Pedido();
		
//		Fornecedor fornecedor = new Fornecedor();
//		fornecedor.setCnpj("123123");
		//Precos[] precos = new Precos[2];
//		
//		fornecedor.setPrecos(precos);


		List<Produto> produtos = new ArrayList<>();
		Produto prod = new Produto();
	//	prod.setGtin(fornecedor.ge);
		prod.setNome(fornecedor.getNome());
		produtos.add(prod);

		Pedido pedido = new Pedido();
		pedido.setFornecedor(fornecedor);
		pedido.setProdutos(produtos);
		

		return pedido;
	}

	@Override
	public <S extends Fornecedor> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fornecedor> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Fornecedor> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fornecedor entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Fornecedor> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
