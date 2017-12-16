package br.com.bluesoft.desafio.api.fornecedor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.repository.FornecedorRepository;

@Controller
@RequestMapping(path="/api/fornecedor")
public class FornecedorController {

	private FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorController(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	@RequestMapping("/{gtin}")
	public Fornecedor findOne(@PathVariable String gtin, Model model, HttpServletRequest request)
			throws JsonProcessingException {
		model.addAttribute("gtin", gtin);
		return fornecedorRepository.findOne(gtin);
	}

}
