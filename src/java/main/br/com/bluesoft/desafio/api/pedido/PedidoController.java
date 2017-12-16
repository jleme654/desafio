//package br.com.bluesoft.desafio.api.pedido;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//
//import br.com.bluesoft.desafio.model.Fornecedor;
//import br.com.bluesoft.desafio.model.Pedido;
//import br.com.bluesoft.desafio.repository.PedidoRepository;
//
///**
// * 
// * @author julio.leme
// * @since 2017-12-15
// * @version 1.0
// */
//@RestController
//@RequestMapping("/api/pedidos")
//public class PedidoController {
//
//	private PedidoRepository pedidoRepository;
//
//	@Autowired
//	public PedidoController(PedidoRepository pedidoRepository) {
//		this.pedidoRepository = pedidoRepository;
//	}
//	
//	@RequestMapping("/{gtin}")
//	public Fornecedor getFornecedorByGtin(@PathVariable String gtin, Model model,
//			HttpServletRequest request) throws JsonProcessingException {
//		model.addAttribute("gtin", gtin);
//		return pedidoRepository.findOne(gtin);
//	}
//
//	@RequestMapping("/{gtin}/{quantidade}")
//	public Pedido getPedidoByGtinAndQuantidade(@PathVariable String gtin, @PathVariable int quantidade, Model model,
//			HttpServletRequest request) throws JsonProcessingException {
//		Fornecedor fornecedor = pedidoRepository.findOne(gtin);
//		return pedidoRepository.getPedidoByGtinAndQuantidade(fornecedor, quantidade);
//	}
//}