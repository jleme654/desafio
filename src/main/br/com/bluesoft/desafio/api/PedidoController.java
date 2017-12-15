package br.com.bluesoft.desafio.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.repository.PedidoRepository;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
@RestController
public class PedidoController {

	private PedidoRepository pedidoRepository;

	@Autowired
	public PedidoController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@RequestMapping("/api/pedido/{gtin}/{quantidade}")
	public Pedido getPedidoByGtinAndQuantidade(@PathVariable String gtin, @PathVariable int quantidade, Model model,
			HttpServletRequest request) throws JsonProcessingException {
		return pedidoRepository.getPedidoByGtinAndQuantidade(gtin, quantidade);
	}
}
