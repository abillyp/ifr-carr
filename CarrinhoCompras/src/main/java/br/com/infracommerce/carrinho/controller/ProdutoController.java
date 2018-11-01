package br.com.infracommerce.carrinho.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.infracommerce.carrinho.model.Produto;
import br.com.infracommerce.carrinho.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto findByCode(@PathVariable Long id) {
		return this.produtoRepository.findOne(id);
	}
	
	@PostMapping()
	public ResponseEntity<Produto> addProduto(@Valid @RequestBody Produto produto) throws URISyntaxException {
		try {
			Produto productSaved = produtoRepository.save(produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
		}catch  (EntityExistsException e) {
			return new ResponseEntity<Produto>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteById(@PathVariable Long id) {
		this.produtoRepository.delete(id);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateById(@PathVariable Long id, @Valid @RequestBody Produto produto) throws URISyntaxException {
		try {
			Produto productSaved = this.produtoRepository.save(produto);
			return ResponseEntity.ok(productSaved);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}
	
}


