package br.com.bluesoft.desafio.api;

import java.net.URL;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.bluesoft.desafio.model.Fornecedor;
import ch.qos.logback.core.net.server.Client;

@RestController
@Configuration
public class FornecedorController {

	public List<Fornecedor> findAllFornecedoresByGtin(@PathVariable String gtin)
			throws JsonProcessingException, InstantiationException, IllegalAccessException {
		
		Client c = Client.class.newInstance();
	    URL wr = c.getClass().getResource("https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/" + gtin);
	    
	    String json = wr.toString();
        Gson gson = new Gson();
        List<Fornecedor> fornecedores = gson.fromJson(json, new TypeToken<List<Fornecedor>>(){}.getType());
	 
        System.out.println(fornecedores);
		return fornecedores;
	}

}
