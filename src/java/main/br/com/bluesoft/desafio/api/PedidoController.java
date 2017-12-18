package br.com.bluesoft.desafio.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.helper.PedidoHelper;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;

/**
 * 
 * @author julio.leme
 * @since 2017-12-15
 * @version 1.0
 */
@RestController
@RequestMapping("/api/pedidos")
@Configuration
public class PedidoController {

	@RequestMapping("/{produtos}")
	public List<Pedido> getNovoPedido(@PathVariable Produto[] produtos, Model model,
			HttpServletRequest request) throws JsonProcessingException {
		
		model.addAttribute("produtos", produtos);
		
		PedidoHelper pedidoHelper = new PedidoHelper();
		List<Pedido> listaPedidos = null;//pedidoHelper.calculaListaPedido(produtos);
		
	    for (Pedido pedido : listaPedidos) {
			System.out.println(pedido);
		}	
	
		return listaPedidos;
	}

}
