package br.com.bluesoft.desafio.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.Gson;

import br.com.bluesoft.desafio.model.Fornecedor;


/**
 * 
 * @author julio.leme
 * @since 2017-12-18
 * @version 1.0
 */
@Controller
@Configuration
public class FornecedorController {

	public List<Fornecedor> findAllFornecedoresByGtin(@PathVariable String gtin)
			throws InstantiationException, IllegalAccessException, IOException, ParseException {

		List<Fornecedor> fornecedores = new ArrayList<>();

		URL url = new URL("https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/" + gtin);
		Reader br = new InputStreamReader(url.openStream());
		

		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(br);
		//System.out.println(jsonArray);
		
		for (Iterator iterator = jsonArray.listIterator(); iterator.hasNext();) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			
			Gson gson = new Gson();
			Fornecedor fornecedor = gson.fromJson(jsonObject.toJSONString(), Fornecedor.class);

			fornecedores.add(fornecedor);
		}
		return fornecedores;
	}
	
	/*public static void main(String[] args) {
		FornecedorController f = new FornecedorController();
		try {

			List<Fornecedor> lista = f.findAllFornecedoresByGtin("7894900011517");
			for (Fornecedor fff  : lista) {
				System.out.println(fff);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}*/
	
	
}
