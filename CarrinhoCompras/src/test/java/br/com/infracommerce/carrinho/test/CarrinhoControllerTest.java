package br.com.infracommerce.carrinho.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
/*import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.infracommerce.carrinho.controller.CarrinhoController;
import br.com.infracommerce.carrinho.model.CarrinhoItem;
import br.com.infracommerce.carrinho.model.Item;
import br.com.infracommerce.carrinho.model.Produto;

@RunWith(SpringRunner.class)
@WebMvcTest(CarrinhoController.class)
public class CarrinhoControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarrinhoItem carrinho;

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() throws Exception{
		Produto produto = new Produto();
		produto.setId(new Long('1'));
		produto.setNome("produto 1");
		produto.setValor(new BigDecimal("10"));
		
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(new Integer(1));
		item.setValorTotal(produto.getValor());
		
		String URI = "localhost:8080/carrinho";
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String inputInJson = objMapper.writeValueAsString(item);
		
		Mockito.when(carrinho.add(Mockito.any(Item.class))).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertEquals("sucesso", outputInJson, inputInJson);
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
*/