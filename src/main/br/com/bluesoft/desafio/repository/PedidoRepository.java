package br.com.bluesoft.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;

public interface PedidoRepository extends CrudRepository<Fornecedor, String> {
	
	public Pedido getPedidoByGtinAndQuantidade(String gtin, int quantidade) throws JsonProcessingException;

}
