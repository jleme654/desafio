package br.com.bluesoft.desafio.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.repository.ProdutoRepository;

public class ProdutoControllerTest {

	@InjectMocks
	ProdutoController produtoController;
	
	@Mock
	ProdutoRepository produtoRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testFindAll() {
		Iterable<Produto> value = Mockito.mock(Iterable.class);
		Mockito.when(this.produtoController.findAll()).thenReturn(value);
	}

}
