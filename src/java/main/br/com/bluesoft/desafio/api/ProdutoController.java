package br.com.bluesoft.desafio.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@Configuration
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    @RequestMapping("/{gtin}")
	public Produto findOne(@PathVariable String gtin, Model model,
			HttpServletRequest request) throws JsonProcessingException {
    	model.addAttribute("gtin", gtin);
		Produto produto = produtoRepository.findOne(gtin);
		return produto;
	}
}
