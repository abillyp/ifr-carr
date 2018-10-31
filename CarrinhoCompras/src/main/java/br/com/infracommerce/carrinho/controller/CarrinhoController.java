package br.com.infracommerce.carrinho.controller;

import java.net.URISyntaxException;
import java.util.Map;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.infracommerce.carrinho.model.CarrinhoItem;
import br.com.infracommerce.carrinho.model.Item;

@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/carrinhos")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoItem carrinho;
	
	@GetMapping
	public Map<Long,Item> itens(){
		Map<Long,Item> itemCarrinho = carrinho.getListaCarrinho();
		return itemCarrinho;
	}
	
	@PostMapping
	public ResponseEntity<Item> add(@RequestBody Item item ) throws URISyntaxException {
		try {
			carrinho.add(item);
			return ResponseEntity.status(HttpStatus.CREATED).body(item);
		}		catch  (EntityExistsException e) {
			return new ResponseEntity<Item>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
	    carrinho.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody Item item){
	    carrinho.updateCarrinho(item);
	}
}