package br.com.bluesoft.desafio.api;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.helper.PedidoHelper;
import br.com.bluesoft.desafio.mock.ProdutoMock;
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

	@RequestMapping(value="/{produtos}", method=RequestMethod.POST)
	public @ResponseBody List<Pedido> getNovoPedido(@RequestParam Produto[] produtos)
			throws JsonProcessingException {
//		 @RequestParam Produto[] produtos, Model model,
//			HttpServletRequest request) throws JsonProcessingException {
//	model.addAttribute("produtos", produtos); 
		
		PedidoHelper pedidoHelper = new PedidoHelper();
		List<Pedido> listaPedidos = pedidoHelper.calculaListaPedido(produtos);

		return listaPedidos;
	}
	
	 @GetMapping
	 public List<Pedido> getListaPedidosMock(){
		
		PedidoHelper pedidoHelper = new PedidoHelper();
		Produto[] produtos = new Produto[] {ProdutoMock.getProdutoMock(), ProdutoMock.getProdutoMock2(), ProdutoMock.getProdutoMock3()};
		List<Pedido> listaPedidos = pedidoHelper.calculaListaPedido(produtos);
		
		for (Pedido pedido : listaPedidos) 
			System.out.println(pedido);
         
		return listaPedidos;
	 }		

}
